package invB18;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Barb
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data/invB2018/JudgeData/barb.dat"));
		
		while(file.hasNext())
		{
			String line = file.nextLine();
			String upper = line.toUpperCase();
			out.print(line+" ");
			
			StringBuilder lol = new StringBuilder(upper);
			lol.reverse();
			out.print(lol+" ");
			
			lol = new StringBuilder(line).reverse();
			int mid = lol.length()/2;
			String aaaaa = lol.substring(mid);
			out.print(aaaaa+" ");
			
			out.println(upper.substring(mid));
		}
		
		file.close();
	}
}
