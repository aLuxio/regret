package algorithms.dynamicProgramming;

import java.util.StringJoiner;

public class Knapsack {
	public static void main(String[] args) {
		int v1[] = { 60, 100, 120 };
		int w1[] = { 10, 20, 30 };
		int W1 = 50;
		System.out.println(knapsack(w1, v1, W1));
		printKnapsack(w1, v1, W1);
		int v2[] = { 40, 100, 50, 60 };
		int w2[] = { 20, 10, 40, 30 };
		int W2 = 60;
		System.out.println(knapsack(w2, v2, W2));
		printKnapsack(w2, v2, W2);
	}

	public static void printKnapsack(int[] wt, int[] vl, int W) {
		int[][] dp = new int[wt.length + 1][W + 1];
		boolean[][] used = new boolean[wt.length + 1][W + 1];
		for(int i = 1; i < dp.length; ++i)
			for(int w = 0; w < dp[0].length; ++w)
				if(wt[i - 1] <= w) {
					int with = vl[i - 1] + dp[i - 1][w - wt[i - 1]];
					if(with > dp[i - 1][w]) {
						dp[i][w] = with;
						used[i][w] = true;
					} else
						dp[i][w] = dp[i - 1][w];
				}
				else
					dp[i][w] = dp[i - 1][w];
		StringJoiner result = new StringJoiner(" ");
		int col = W;
		for(int row = wt.length; row >= 0; --row) {
			if(used[row][col]) {
				result.add("" + (row - 1) + "(" + wt[row - 1] + ")");
				col -= wt[row - 1];
			}
		}
		System.out.println(result);
	}

	public static int knapsack(int[] wt, int[] vl, int W) {
		int[][] dp = new int[wt.length + 1][W + 1];
		for(int i = 1; i < dp.length; ++i)
			for(int w = 0; w < dp[0].length; ++w)
				if(wt[i - 1] <= w)
					dp[i][w] = Math.max(dp[i - 1][w - wt[i - 1]] + vl[i - 1], dp[i - 1][w]);
				else
					dp[i][w] = dp[i - 1][w];
		return dp[wt.length][W];
	}
}
