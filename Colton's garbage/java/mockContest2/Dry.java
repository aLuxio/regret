package mockContest2;

import static java.lang.System.*;
import java.util.*;
import java.io.*;


public class Dry
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data/mc1116/SampleData/dry.dat"));
		int count = file.nextInt();
		file.nextLine();
		
		for(; count>0; count--)
		{
			String in = file.nextLine();
			String temp = "";
			int a=0, b=in.length()-1;
			while(b>0)
			{
				
			}
		}
		
		file.close();
	}
	
	public static boolean check(String lol)
	{
		
	}
}
