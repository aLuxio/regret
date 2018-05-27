package Region.reg2015;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Tri {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/Region/reg2015/data/judgedata/tri.dat"));
		while(file.hasNext()) {
			BigInteger[] sides = { file.nextBigInteger(), file.nextBigInteger(), file.nextBigInteger() };
			Arrays.sort(sides);
			System.out.printf("%d %d %d %s%n", sides[0], sides[1], sides[2],
					sides[0].add(sides[1]).compareTo(sides[2]) > 0 ? "YES" : "NO");
		}
		file.close();
	}
}
