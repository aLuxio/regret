package Region.reg2015;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/region/reg2015/data/studentdata/fibonacci.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			c = 0;
			calls = new HashSet<>();
			fibonacci(file.nextInt());
			System.out.println(c);
		}
		file.close();
	}

	static HashSet<Integer> calls;
	static int c;

	public static int fibonacci(int n) {
		if(calls.contains(n))
			c++;
		calls.add(n);
		if(n == 0 || n == 1)
			return n;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
