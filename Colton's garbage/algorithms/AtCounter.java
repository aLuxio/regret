package algorithms;

public class AtCounter
{
	public static int count(int[][] in, int x, int y, int z)
	{
		if(Math.min(x, y) >= 0 && x < in.length && y < in[x].length && in[x][y]==z)
		{
			in[x][y] = ~in[x][y];
			return count(in, x+1, y, z) +
					count(in, x, y+1, z) +
					count(in, x-1, y, z) +
					count(in, x, y-1, z) +1;
		}
		
		return 0;
	}
	
	public static void main(String[] args)
	{
		int[][] a = {{0, 3, 4, 4, 2, 9, 4},
					 {4, 2, 4, 3, 2, 1, 8},
					 {4, 4, 4, 4, 3, 5, 6},
					 {2, 0, 4, 4, 4, 4, 5}};
		System.out.println(count(a, 2, 2, a[2][2]));
	}
}
