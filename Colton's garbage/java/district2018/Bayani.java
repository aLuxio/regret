package district2018;

import static java.lang.System.*;
import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Bayani
{
	public static void main(String[] args) throws IOException
	{
		double[] a = Files.lines(Paths.get("data/district2018/judgedata/bayani.dat"))
			.mapToDouble(Double::parseDouble)
			.toArray();
		double total = Arrays.stream(a).sum();
		
		Arrays.stream(a).forEachOrdered(i -> out.printf("\t$%7.2f%n", i));
		out.printf("Total = $%7.2f%n", total);
	}
}
