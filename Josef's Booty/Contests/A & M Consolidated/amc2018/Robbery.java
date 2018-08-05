package amConsolidated.amc2018;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Robbery {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("robbery.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			System.out.println(knapsack(file.nextInt(), Integer.parseInt(file.nextLine().trim()),
					Arrays.stream(file.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray(),
					Arrays.stream(file.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray()));
		}
		file.close();
	}

	public static long knapsack(int W, int n, int[] vl, int[] wt) {
		long[][] a = new long[wt.length + 1][W + 1];
		for(int i = 1; i < a.length; ++i)
			for(int j = 0; j < a[0].length; ++j)
				if(j >= wt[i - 1]) {
					a[i][j] = Math.max(a[i - 1][j], a[i - 1][j - wt[i - 1]] + vl[i - 1]);
				} else
					a[i][j] = a[i - 1][j];
		return a[wt.length][W];
	}
}
