public class Knapsack
{
	//lol just use Math.max() I'm just a lazy boi
	static int max(int a, int b)
	{
		return (a > b) ? a : b;
	}
	
	//probably not a good idea to use since its runtime is O(2^n) oof
	static int recur(int cap, int[] wt, int[] val, int n)
	{
		if (n == 0 || cap == 0)
			return 0;

		if (wt[n - 1] > cap)
			return recur(cap, wt, val, n - 1);

		return max(
				val[n - 1] + recur(cap - wt[n - 1], wt, val, n - 1),
				recur(cap, wt, val, n - 1));
	}
	
	//heckin good boi right here
	static int dynamic(int W, int[] wt, int[] val, int n)
	{
		int x, y;
		int[][] K = new int[n+1][W+1];
		
		for(y=0; y<=n; y++)
		{
			for(x=0; x<=W; x++)
			{
				if(y==0 || x==0)
					K[y][x] = 0;
				else if(wt[y-1] <= x)
					K[y][x] = max(val[y-1] + K[y-1][x-wt[y-1]], K[y-1][x]);
				else
					K[y][x] = K[y-1][x];
			}
		}
		
		return K[n][W];
	}

	/*
	 * main lol
	 */
	public static void main(String[] gimmeSomeSucc)
	{
		int[] val = {60, 100, 120};
		int[] wt  = {10, 20, 30};
		int W = 50;
		int n = val.length;
		System.out.println(recur(W, wt, val, n));
		System.out.println(dynamic(W, wt, val, n));
	}
}
