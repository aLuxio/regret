package mockContest1;

import static java.lang.System.*;
import java.util.*;
import java.io.*;


public class Digits
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data\\mc1017\\JudgesData\\digits.dat"));
		int count = file.nextInt();
		file.nextLine();
		
		for(int a=0; a<count; a++)
		{
			String line = file.nextLine();
			int sum = 0;
			
			for(char ind : line.toCharArray())
				sum += Character.getNumericValue(ind);
			
			out.println(sum);
		}
		
		file.close();
	}
}
