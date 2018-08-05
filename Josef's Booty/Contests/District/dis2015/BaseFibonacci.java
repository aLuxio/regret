package District.dis2015;

import java.util.*;
import java.io.*;
public class BaseFibonacci {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src\\District\\dis2015\\data\\JudgeData\\base.dat"));
		while(file.hasNext()) {
			int N = file.nextInt();
			long[] fib = new long[N / 2 + 2];
			for(int i = 0; i < fib.length; ++i) {
				fib[i] = i < 2 ? i + 1 : fib[i - 1] + fib[i - 2];
			}
			List<String> nums = new ArrayList<>();
			for(int i = fib.length-1, goal = N; i >= 0; --i) {
				if(fib[i] > 0 && fib[i] <= goal) {
					goal -= fib[i];
					nums.add("" + fib[i]);
				}
			}
			System.out.println(N + " = " + String.join(" + ", nums));
		}
	}
}
