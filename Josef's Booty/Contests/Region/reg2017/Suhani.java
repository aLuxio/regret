package Region.reg2017;

import java.util.*;
import java.io.*;
public class Suhani
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("src\\Regional2017\\suhani.dat"));
		while(file.hasNext())
		{
			ArrayList<Double> thing = new ArrayList<>();
			thing.add(file.nextDouble());
			thing.add(file.nextDouble());
			thing.add(file.nextDouble());
			thing.remove(file.nextDouble());
			thing.remove(file.nextDouble());
			thing.remove(file.nextDouble());
			System.out.println(3 - thing.size());
		}
	}
}
