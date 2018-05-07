package invB18;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Emily
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data/invB2018/JudgeData/emily.dat"));
		while(file.hasNext())
		{
			double b1 = file.nextDouble(),
					b2 = file.nextDouble(),
					h = file.nextDouble();
			double area = (b1+b2)*h/2;
			if(area%1==0)
				out.println((int)area);
			else
				out.printf("%.1f%n", area);
		}
		file.close();
	}
}
