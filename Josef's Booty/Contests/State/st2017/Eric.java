package State.st2017;
import java.util.*;
import java.io.*;
public class Eric
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("src\\State2017\\data\\eric.txt"));
		while(file.hasNextLine())
		{
			int a = file.nextInt(), b = file.nextInt();
			int c = a, d = b;
			int e = 2;
			do
			{
				int t = c;
				c = d % 10;
				d = (t + d) % 10;
				e++;
			}while(c != a || d != b);
			System.out.println(e);
		}
	}
}
