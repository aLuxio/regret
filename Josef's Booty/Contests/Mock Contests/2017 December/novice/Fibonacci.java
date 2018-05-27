package mockContests.december2017.novice;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/december2017/novice/data/judgesdata/fibonacci.dat"));
		long[] f = new long[99];
		f[1] = 1;
		for(int i = 2; i < f.length; ++i)
			f[i] = f[i - 1] + f[i - 2];
		for(int T = file.nextInt(); T > 0; --T) {
			int index = file.nextInt();
			System.out.println(index + " = " + f[index - 1]);
		}
	}
}
