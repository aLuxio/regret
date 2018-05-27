package State.st2017;
import java.util.*;
import java.io.*;
public class Changpu
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("src\\State\\st2017\\data\\changpu.txt"));
		while(file.hasNextInt())
		{
			int i = file.nextInt();
			System.out.println(i + " " + ((i&1)==1?-i:~i));
		}
	}
}
