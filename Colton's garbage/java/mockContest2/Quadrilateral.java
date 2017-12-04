package mockContest2;

import static java.lang.System.out;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Quadrilateral
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data/mc1116/SampleData/quadrilateral.dat"));
		int oof = file.nextInt();
		
		for(int i=0; i<oof; i++)
		{
			int a = file.nextInt(), b = file.nextInt();
			for(; b>0; b--)
			{
				for(int x=0; x<a; x++)
					out.print("X");
				out.println();
			}
			out.println();
		}
	}
}
