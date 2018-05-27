package State.st2017;
import java.util.*;
import java.io.*;
public class Guang
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("src\\State\\st2017\\data\\guang.txt"));
		while(file.hasNext())
		{
			int a = file.nextInt(), b = file.nextInt();
			String c = Integer.toString(a, b);
			int len = c.length() * 2;
			while(c.length() != len)
				c = "0" + c;
			System.out.println(c.toUpperCase());
		}
	}
}