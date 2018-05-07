package algorithms;

// Yeah, I know it's not counting @s, but it's the same algorithm.
// similar problems are Mooscular
public class AtCounter
{
	public static int count(int[][] in, int x, int y, int z)
	{
		// in = array of data
		// x = row of starting position
		// y = column of starting position
		// z = item being searched for (can be hard-coded in if the program permits)
		if(Math.min(x, y) >= 0 && x < in.length && y < in[x].length && in[x][y]==z)
		{
			// the Math.min() makes it easier to check if your values are out of bounds
			// because it only takes one OOB variable to break the method
			// you could use Math.max() to check the high boundaries if the number of cells
			// in the matrix is square (both the number of rows and columns are the same).
			// this is why I didn't do it here; the number of rows is not equal to the
			// number of columns
			// *************************************************************************
			// if you're doing this with characters, you would change the character
			// to something signifying that it has been visited while retaining its
			// status
			in[x][y] = ~in[x][y];
			
			// the algorithm checks the vertically and horizontally adjacent cells to
			// the current cell
			return count(in, x+1, y, z) +
					count(in, x, y+1, z) +
					count(in, x-1, y, z) +
					count(in, x, y-1, z) +1;
		}
		
		return 0;
	}
	
	public static void main(String[] args)
	{
		// this would obviously be read in from a file if this were a contest problem
		int[][] a = {{0, 3, 4, 4, 2, 9, 4},
			     {4, 2, 4, 3, 2, 1, 8},
			     {4, 4, 4, 4, 3, 5, 6},
			     {2, 0, 4, 4, 4, 4, 5}};
		System.out.println(count(a, 2, 2, a[2][2]));
	}
}
