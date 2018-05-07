package district2018;

import static java.lang.System.*;
import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Raymond
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data/district2018/judgedata/raymond.dat"));
		
		while(file.hasNext())
		{
			int temp = file.nextInt();
			out.println(temp+" "+~temp);
		}
		
		file.close();
	}
}
