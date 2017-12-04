//Mock Contest 10-17-2017 - Problem 4 - Cheater

package mockContest1;

import static java.lang.System.*;
import java.util.*;
import java.io.*;


public class Cheater
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data\\mc1017\\JudgesData\\cheater.dat"));
		int count = file.nextInt();
		file.nextLine();
		
		TreeMap<String, Integer> hist = new TreeMap<>();
		
		for(int a=0; a<count; a++)
		{
			String temp = file.nextLine();
			if(hist.get(temp)==null)
				hist.put(temp, 1);
			else
				hist.put(temp, hist.get(temp)+1);
		}
		List<Integer> values = new ArrayList<>(hist.values());
		Collections.sort(values, Collections.reverseOrder());
		//out.println(values);
		
		//Brute force method. Not pretty, but it works.
		for(int val : values)
		{
			for(String key : hist.keySet())
			{
				if(hist.get(key) == val)
					out.println(key);
			}
		}
		
		file.close();
	}
}
