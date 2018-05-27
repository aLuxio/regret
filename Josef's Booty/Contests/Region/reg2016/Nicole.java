package Region.reg2016;

import java.util.stream.*;
import java.util.*;
import java.io.*;
public class Nicole
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("src\\Region\\reg2016\\data\\nicole.txt"));
		while(file.hasNext())
			Stream.iterate(new int[]{file.nextInt(), file.nextInt(), file.nextInt()}, x -> new int[]{x[1], x[2], x[0] + x[1] + x[2] - 3}).mapToInt(arr -> arr[0]).skip(file.nextInt()-1).limit(1).forEachOrdered(System.out::println);
	}
}
