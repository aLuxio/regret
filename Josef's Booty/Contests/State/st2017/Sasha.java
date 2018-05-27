/*Prob.10 State 2017
 * 
 */

import static java.lang.System.*;
import java.math.*;
import java.util.*;
import java.awt.*;
import java.io.*;

public class Sasha
{
	public static void main(String[] args) throws IOException
	{
		File stu = new File("StudentData/Sasha.dat");
		File judge = new File("JudgesData/Sasha.dat");
		Scanner file = new Scanner(judge);
		
		int lines = file.nextInt();
		file.nextLine();
		while (lines --> 0)
		{
			String line = file.nextLine();
			ArrayList<Integer> first = new ArrayList<Integer>();
			do
			{
				if(numHash(line) >= 0)
					first.add(numHash(line));
				line = file.nextLine();
			}while(!line.equals("-"));
			
			line = file.nextLine();
			ArrayList<Integer> sec = new ArrayList<Integer>();
			do
			{
				if(numHash(line) >= 0)
					sec.add(numHash(line));
				line = file.nextLine();
			}while(!line.equals("--"));
			
			//out.println(first);
			//out.println(sec);
			
			ArrayList<Integer> key = new ArrayList<Integer>();
			for(int p=0; p<sec.size(); ++p)
			{
				int pos = (int)((p/(double)sec.size())*first.size());
				pos = pos>= first.size()?first.size()-1:pos;
				key.add((int)(((double)first.get(pos)/first.size())*sec.size()));
			}
			//out.println(key);
			out.println(key.equals(sec) ? "SAME" : "DIFFERERNT");
		}
	}
	
	public static int numHash(String line)
	{
		return line.lastIndexOf("#") + 1 - Math.abs(line.indexOf("#"));
	}
}
