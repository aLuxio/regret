package district2017;
/* Colton Mikeska	April 6, 2017	UIL District 2017, Hyo
 *
 * This is by NO means the best way to do this, but it's my way, and I'm proud of it, okay!?
 */

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Hyo
{

    public static void main(String[] args) throws IOException
    {
    	Scanner file = new Scanner(new File("data\\2017 District\\JudgeData\\hyo.dat"));
    	int count = file.nextInt();
    	
    	for(int a=0; a<count; a++)
    	{
    		//this will hold the names and a list of people they're friends with
    		//using a map IS the actual best way to do this, so I'm not a complete dumbass
    		//	...emphasis on "complete"
    		Map<String, List<String>> names = new HashMap<>();
    		int count2 = file.nextInt();
    		file.nextLine();
    		//loads all the names into the map
    		for(int b=0; b<count2; b++)
    		{
    			//splits line on one or more colons and whitespaces in succession
    			String[] chop = file.nextLine().split("[:\\s]+");
    			//this will be the key
    			String name = chop[0];
    			//this will be placed at the key
    			List<String> temp = new ArrayList<>();
    			for(int c=1; c<chop.length; c++)
    				temp.add(chop[c]);
    			names.put(name, temp);
    		}
    		//separates the initial name from the target name
    		//I use split a lot, don't judge
    		String[] check = file.nextLine().split("\\s");
    		String start = check[0];
    		String finish = check[1];
    		
    		//holds the degree from initial name to target name
    		int degree = recur(start, finish, names);
    		out.println("The degree of separation between "+check[0]+" and "+check[1]+" is "+degree+".");
    		String output = "";
    		while(relations.size()>0)
    		{
    			output += relations.size()!=1 ? relations.poll() + " is a friend of " : relations.poll()+".";
    		}
    		relations.clear();
    		out.println(output);
    		out.println();
    	}
    }
    
    //instance variables
    //I wasn't completely sure if you could modify non-static variables from a static method,
    //	so better safe than sorry
    static String nextName;	//holds the next name
    static int previous = 0;
    static int count = 0;
    //holds the names previously checked, you'll see why later
   	static Stack<String> checked = new Stack<>();
   	//holds the actual order of the relationship
   	static Queue<String> relations = new LinkedList<>();
    
    
    //where the m a g i c happens
    private static int recur(String s, String e, Map<String, List<String>> map)
    {
    	List<String> temp = map.get(s);
    	Collections.sort(temp);
    	count++;
    	
    	if(temp.contains(e))
    	{
    		//this block basically resets everything
    		relations.add(s);
    		relations.add(e);
    		previous = count;
    		count = 0;
    		checked.clear();
    		out.println(relations.toString());
    		return previous;
    		//return relations.size();
    	}
    	else
    	{
    		temp.removeAll(checked);
    		if(temp.isEmpty())
    		{
    			count--;
    			nextName = checked.peek();
    		}
    		if(relations.contains(s))
    			count--;
    		G:for(String index : temp)
    		{	
    			if(!checked.contains(index))
    			{
    				if(!relations.contains(s))
    					relations.add(s);
    				nextName = index;
    				break G;
    			}
    		}
    		checked.push(s);
    		//out.println(checked);
    		return recur(nextName, e, map);
    	}
    }
    
    
}