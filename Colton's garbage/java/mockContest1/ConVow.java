package mockContest1;

import static java.lang.System.*;
import java.util.*;
import java.io.*;


public class ConVow
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data\\mc1017\\JudgesData\\convow.dat"));
		
		while(file.hasNext())
		{
			String line = file.nextLine();
			String vowels = "aeiou";
			int index = 0;
			
			for(int a=0; a<line.length(); a++)
			{
				if(!Character.toString(line.charAt(a)).matches("[ "+vowels+"]"))
					line = line.replaceFirst(Character.toString(line.charAt(a)), Character.toString(vowels.charAt(index++%5)));
			}
			out.println(line);
		}
		
		file.close();
	}
}
