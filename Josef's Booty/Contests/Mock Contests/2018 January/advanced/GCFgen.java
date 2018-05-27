package mockContests.january2018.advanced;

import java.util.Random;

public class GCFgen {
	public static void main(String[] args) {
		Random randy = new Random();
		int[] m = { 5, 12, 45, 9, 5, 3, 17, 32, 64, 74, 24, 7, 235, 45, 7, 9, 1, 32, 1, 1, 7 };
		for(int i = 0; i < 3; ++i) {
			int n = randy.nextInt(10);
			for(int v = 0; v <= n; ++v)
				System.out.print(m[i] * (2 + randy.nextInt(9)) + " ");
			System.out.println();
		}
	}
}
