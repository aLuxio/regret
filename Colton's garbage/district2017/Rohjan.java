package district2017;
import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Rohjan
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data\\2017 State\\rohan.dat"));
		Scanner chop;
		
		while(file.hasNext())
		{
			chop = new Scanner(file.nextLine());
			
			//[Xa, Ya, Xb, Yb, Xc, Yc]
			double[] data = new double[6];
			for(int x=0; x<data.length; x++)
				data[x] = chop.nextDouble();
			
			double a=0, b=0, c=0 ;
			c = Math.abs(a-b);
			a = Math.abs(b-c);
			b = Math.abs(a-c);
			
			
			double YI = (a*data[1] + b*data[3] + c*data[5]) / (a+b+c);
			double XI = (a*data[0] + b*data[2] + c*data[4]) / (a+b+c);
			double YC = (data[1] + data[3] + data[5]) / 3;
			double XC = (data[0] + data[2] + data[4]) / 3;
			double s = 0;
			double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
			
			out.printf("(%.2f,%.2f)", XI, YI);
			out.printf("(%.2f,%.2f)", XC, YC);
			out.println();
		}
		
	}
}
