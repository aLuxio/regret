package district2018;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Nandita
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data/district2018/judgedata/nandita.dat"));
		
		while(file.hasNext())
		{
			int month = getMonth(file.next()),
					day = Integer.parseInt(file.next().replaceAll("\\D+", "")),
					year = file.nextInt();
			
			out.printf("%02d/%02d/%s%n", month, day, Integer.toString(year).substring(2));
			out.printf("%02d.%02d.%d%n", day, month, year);
			out.printf("%d-%02d-%02d%n", year, month, day);
			out.println("=====");
		}
		
		file.close();
	}
	
	public static int getMonth(String in)
	{
		//-_- lol overcomplicated rip
		switch(in)
		{
		case "FEBRUARY": return Calendar.FEBRUARY+1;
		case "MARCH": return Calendar.MARCH+1;
		case "APRIL": return Calendar.APRIL+1;
		case "MAY": return Calendar.MAY+1;
		case "JUNE": return Calendar.JUNE+1;
		case "JULY": return Calendar.JULY+1;
		case "AUGUST": return Calendar.AUGUST+1;
		case "SEPTEMBER": return Calendar.SEPTEMBER+1;
		case "NOVEMBER": return Calendar.NOVEMBER+1;
		case "DECEMBER": return Calendar.DECEMBER+1;
		default: return Calendar.JANUARY+1;
		}
	}
}
