package amConsolidated.amc2018;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Combinations {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("combinations.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			System.out.println(coinCombos(file.nextInt(), Integer.parseInt(file.nextLine().trim()),
					Arrays.stream(file.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray()));
		}
		file.close();
	}

	public static long coinCombos(int G, int c, int[] coins) {
		long[] dp = new long[G + 1];
		dp[0] = 1;
		for(int coin : coins)
			for(int i = coin; i <= G; ++i)
				dp[i] += dp[i - coin];
		return dp[G];
	}
}
