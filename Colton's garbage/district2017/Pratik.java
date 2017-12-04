package district2017;
import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Pratik
{

    public static void main(String[] args) throws IOException
    {
    	Scanner file = new Scanner(new File("data\\2017 District\\StudentData\\pratik.dat"));
    	int count = file.nextInt();
    	List<String[][]> clock = new ArrayList<>();
    	
    	clock.add(zero());
    	clock.add(four());
    	
    	for(int a=0; a<clock.size(); a++)
    	{
    		out.println(toString(clock));
    	}
    }
    
    public static String[][] zero()
    {
    	String[][] mat = new String[5][5];
    	for(int a=0; a<5; a++)
    	{
    		if(a==0 || a==4)
    		{
    			for(int b=0; b<5; b++)
    				mat[a][b] = "#";
    		}
    		else
    		{
    			mat[a][0] = "#";
    			for(int b=1; b<4; b++)
    				mat[a][b] = " ";
    			mat[a][4] = "#";
    		}
    	}
    	return mat;
    }
    
    public static String[][] four()
    {
    	String[][] mat = new String[5][5];
    	for(int a=0; a<5; a++)
    	{
    		if(a==0 || a==1)
    		{
    			mat[a][0] = "#";
    			for(int b=1; b<4; b++)
    				mat[a][b] = " ";
    			mat[a][4] = "#";
    		}
    		else if(a==3 || a==4)
    		{
    			for(int b=0; b<4; b++)
    				mat[a][b] = " ";
    			mat[a][4] = "#";
    		}
    		else
    		{
    			for(int b=0; b<5; b++)
    				mat[a][b] = "#";
    		}
    	}
    	return mat;
    }
    
    public static String toString(List<String[][]> e)
    {
    	String output = "";
    	
    	for(int bigRow=0; bigRow<5; bigRow++)
    	{
    		for(int listIndex=0; listIndex<e.size(); listIndex++)
    		{
    			for(int row=0; row<e.get(listIndex).length; row++)
    			{
    				for(int col=0; col<e.get(listIndex)[row].length; col++)
    					output += e.get(listIndex)[row][col];
    				output += " ";
    			}
    		}
    		output += "\n";
    	}
    	
    	return output;
    }
    
}