package mockContest1;

import static java.lang.System.*;
import java.util.*;
import java.io.*;


public class Between
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data\\mc1017\\JudgesData\\between.dat"));
		int count = file.nextInt();
		file.nextLine();
		
		for(int a=0; a<count; a++)
		{
			String line = file.nextLine();
			
			while(line.length() > 1)
			{
				out.println(line);
				line = line.substring(1, line.length()-1);
			}
			
			out.println();
		}
		
		file.close();
	}
}
