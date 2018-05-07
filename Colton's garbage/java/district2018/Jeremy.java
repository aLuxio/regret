package district2018;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Jeremy
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data/district2018/judgedata/jeremy.dat"));
		int c = file.nextInt();
		
		for(; c>0; c--)
		{
			int[][] mat = new int[file.nextInt()][file.nextInt()];
			file.nextLine();
			for(int r=0; r<mat.length; r++)
				mat[r] = Arrays.stream(file.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
			
			solve(mat, file.nextInt(), file.nextInt(), file.nextInt());
			for(int[] r : mat)
			{
				String printing = "";
				for(int n : r)
					printing += n+" ";
				out.println(printing.trim());
			}
			out.println("=====");
		}
		
		file.close();
	}
	
	public static void solve(int[][] in, int x, int y, int dz)
	{
		//out.printf("x = %d%ny = %d%ndz = %d%n", x, y, dz);
		help(in, x, y, dz, in[x][y]);
	}
	
	public static void help(int[][] in, int x, int y, int dz, int z)
	{
		if(Math.min(x, y) >= 0 && x < in.length && y < in[x].length && in[x][y]==z)
		{
			in[x][y] = dz;
			help(in, x+1, y, dz, z);
			help(in, x, y+1, dz, z);
			help(in, x-1, y, dz, z);
			help(in, x, y-1, dz, z);
		}
	}
}
