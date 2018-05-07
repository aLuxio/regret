package district2018;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Diya
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data/district2018/judgedata/diya.dat"));
		
		while(file.hasNext())
		{
			int size = file.nextInt();
			int mat[][] = new int[size][size];
			int area = size * size;	//convenience variable
			
			//traversal matricies
			byte[] dx = {1, 0, -1, 0};
			byte[] dy = {0, 1, 0, -1};
			
			int x=0, y=0, n=1, i=0;
			while(n <= area)
			{
				mat[y][x] = n;
				if(Math.min(x+dx[i], y+dy[i])>=0 && Math.max(x+dx[i], y+dy[i])<size && mat[y+dy[i]][x+dx[i]] == 0)
				{
					x += dx[i];
					y += dy[i];
					n++;
				}
				else if(n == area)
					break;
				else
					i = i==3 ? 0 : i+1;
			}
			
			for(int[] r : mat)
			{
				for(int a : r)
					out.printf("%-"+Integer.toString(area).length()+"d ", a);
				out.println();
			}
			
			out.println("=====");
		}
		
		file.close();
	}
}
