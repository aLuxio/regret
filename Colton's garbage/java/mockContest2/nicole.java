package mockContest2;

import static java.lang.System.*;
import java.math.*;
import java.util.*;
import java.io.*;

public class nicole
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data/mc1116/SampleData/nicole.dat"));
		
		while(file.hasNext())
		{
			BigInteger oof1 = new BigInteger(file.next());
			BigInteger oof2 = new BigInteger(file.next());
			BigInteger oof3 = new BigInteger(file.next());
			int n = file.nextInt();
			
			for(int lol=3; lol<n; lol++) {
				BigInteger temp = (oof3.add(oof2.add(oof1))).subtract(new BigInteger("3"));
				oof1 = oof2;
				oof2 = oof3;
				oof3 = temp;
				//out.print(oof3+" ");
			}
			
			out.println(oof3);
		}
		
		file.close();
	}
}
