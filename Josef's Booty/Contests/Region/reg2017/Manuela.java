package Region.reg2017.A;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Manuela {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/Region/reg2017/data/judgedata/manuela.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			int n = Integer.parseInt(file.nextLine());
			int[] coins = new int[n];
			String[] denoms = new String[n];
			for(int i = 0; i < n; ++i) {
				denoms[i] = file.next();
				coins[i] = Integer.parseInt(file.nextLine().trim());
			}
			int goal = Integer.parseInt(file.nextLine());
			System.out.println(minCoins(denoms, coins, goal));
		}
		file.close();
	}

	public static String minCoins(String[] denoms, int[] coins, int goal) {
		int[] dp = new int[goal + 1];
		int[] re = new int[goal + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		for(int i = 1; i <= goal; ++i)
			for(int c = 0; c < coins.length; ++c)
				if(coins[c] <= i && dp[i - coins[c]] != -1)
					if(dp[i] == -1 || dp[i - coins[c]] < dp[i]) {
						dp[i] = dp[i - coins[c]] + 1;
						re[i] = c;
					}
		int pos = goal;
		int[] count = new int[coins.length];
		while(pos > 0) {
			int c = re[pos];
			count[c]++;
			pos -= coins[c];
		}
		return IntStream.range(0, coins.length).boxed().sorted(Comparator.comparing(x -> denoms[x]))
				.filter(x -> count[x] > 0).map(x -> denoms[x] + ": " + count[x]).collect(Collectors.joining(" "));
	}
}
