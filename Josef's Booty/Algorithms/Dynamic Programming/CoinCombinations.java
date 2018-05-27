package algorithms.dynamicProgramming;

import java.util.*;
import java.io.*;
public class CoinCombinations {
	public static void main(String[] args) {
		System.out.println(coins(new int[] {3, 4}, 7));
		System.out.println(coins(new int[] {2, 3, 4}, 9));
		System.out.println(coins(new int[] {1, 5}, 15));
		System.out.println(coins(new int[] {1, 5, 10, 25}, 40));
		System.out.println(coins(new int[] {1, 8, 9}, 50));
		System.out.println(coins(new int[] {8, 9}, 50));
		System.out.println(coins(new int[] {7, 6}, 50));
		System.out.println(coins(new int[] {9}, 50));
	}

	public static int coins(int[] coins, int goal) {
		int[] dp = new int[goal + 1];
		dp[0] = 1;
		for(int coin : coins)
			for(int i = coin; i <= goal; ++i)
				dp[i] += dp[i - coin];
		return dp[goal];
	}
}
