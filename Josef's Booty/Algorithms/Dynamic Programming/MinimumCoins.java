package algorithms.dynamicProgramming;

import java.util.Arrays;

public class MinimumCoins {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(minimumCoins(new int[]{1, 4, 5, 8, 11}, 29)));
		System.out.println(Arrays.toString(minimumCoins(new int[]{1, 5, 10, 25, 50, 100}, 96)));
		System.out.println(Arrays.toString(minimumCoins(new int[]{1, 2, 6, 12, 24, 48, 60}, 96)));
		System.out.println(Arrays.toString(minimumCoins(new int[]{1, 3, 4}, 6)));
		System.out.println(Arrays.toString(minimumCoins(new int[]{16, 17, 23, 24, 39, 40}, 100)));
		System.out.println(Arrays.toString(minimumCoins(new int[]{6, 9, 20}, 43)));
	}
	
	public static int[] minimumCoins(int[] coins, int goal) {
		if(coins == null) {
			throw new IllegalArgumentException("Coins must not be null");
		} else if(goal < 0) {
			throw new IllegalArgumentException("Goal must be positive");
		}
		int[] dp = new int[goal + 1];
		int[] re = new int[goal + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		for(int i = 0; i <= goal; ++i) {
			for(int j = 0; j < coins.length; ++j) {
				int coin = coins[j];
				if(coin <= i && dp[i-coin] != -1) {
					if(dp[i] == -1 || (dp[i-coin] < dp[i])) {
						dp[i] = dp[i-coin] + 1;
						re[i] = j;
					}
				}
			}
		}
		int[] chosen = new int[coins.length];
		if(dp[goal] > 0) {
			int pos = goal;
			while(pos != 0) {
				int c = re[pos];
				chosen[c]++;
				pos -= coins[c];
			}
		}
		return chosen;
	}
}

