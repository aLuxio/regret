package mockContest2;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Microwave
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data\\mc1116\\SampleData\\microwave.dat"));
		int oof = file.nextInt();
		
		for(int a=0; a<oof; a++)
		{
			int seconds = file.nextInt();
			if(seconds<100)
				out.println(seconds+" seconds = "+a(seconds)+" minutes.");
			else
			{
				//int newSeconds = seconds
				String lol = Integer.toString(seconds);
				int minutes;
				if(lol.length()==3)
					minutes = Integer.parseInt(lol.substring(0, 1)) * 60;
				else
					minutes = Integer.parseInt(lol.substring(0, 2)) * 60;
				out.println(seconds+" seconds = "+minutes+":"+seconds+" minutes.");
			}
				//out.println("lol");
		}
	}
	
	public static String a(int seconds)
	{
		int minutes = seconds / 60;
		seconds %= 60;
		return String.format("%02d:%02d", minutes, seconds);
	}
}
