package mockContests.december2017.advanced;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Kaprekar {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/december2017/advanced/data/sampledata/kaprekar.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			int n = file.nextInt();
			boolean h = harshad(n), k = kaprekar(n);
			if(h)
				System.out.println("Great Joy");
			if(k)
				System.out.println("Kaprekar");
			else if(!h)
				System.out.println("Neither");
			System.out.println();
		}
		file.close();
	}

	public static boolean harshad(int n) {
		return n % Integer.toString(n).chars().map(x -> x - 48).sum() == 0;
	}

	public static boolean kaprekar(int n) {
		String pow = Integer.toString(n * n);
		return n == 1 || IntStream.range(1, pow.length())
				.anyMatch(num -> Integer.parseInt(pow.substring(0, num)) + Integer.parseInt(pow.substring(num)) == n);
	}
}
