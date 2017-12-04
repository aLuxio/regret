package mockContest2;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class gears
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data/mc1116/JudgesData/gears.dat"));
		int oof = file.nextInt();
		file.nextLine();
		
		for(int a=0; a<oof; a++)
		{
			String line = file.nextLine();
			int count = 0;
			
			while(line.matches(".*[A-Z\\~\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\_\\+\\{\\}\\|\\:\"\\<\\>\\?]+.*"))
			{
				line = line.replaceFirst("[A-Z\\~\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\_\\+\\{\\}\\|\\:\"\\<\\>\\?]+", "");
				count++;
			}
			out.println("The shift key was pressed "+count+" times.");
		}
		
		file.close();
	}
}
