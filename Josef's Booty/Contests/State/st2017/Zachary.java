package State.st2017;
import java.util.*;
import java.io.*;
public class Zachary
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("src\\State\\st2017\\data\\zachary.txt"));
		while(file.hasNextLine())
		{
			int a = file.nextInt(), b = file.nextInt();
			for(int i = 1; i <= a; i++)
			{
				for(int j = 1; j <= b; j++)
					System.out.print(i*j%10);
				System.out.println();
			}
		}
	}
}
