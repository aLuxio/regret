package District.dis2016;

import java.util.*;
import java.util.stream.Stream;
import java.io.*;
import java.math.BigInteger;
public class Tomas {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src\\District\\dis2016\\data\\tomas.dat"));
		while(file.hasNext()) {
			Stream.iterate(new BigInteger[] {BigInteger.ONE, BigInteger.ONE, BigInteger.ONE},
					x -> new BigInteger[] {x[1], x[2], x[0].add(x[1]).add(x[2])}).map(x -> x[0].toString())
					.skip(file.nextInt() - 1).limit(1).forEach(System.out::println);
		}
	}
}
