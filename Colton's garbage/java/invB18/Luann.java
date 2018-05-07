package invB18;

import static java.lang.System.*;

import java.awt.Point;
import java.util.*;
import java.io.*;

public class Luann
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data/invB2018/judgedata/luann.dat"));
		int count = file.nextInt();
		
		for(; count>0; count--)
		{
			List<Point> points = new ArrayList<>();
			int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
			int i = file.nextInt();
			for(; i>0; i--) {
				int x = file.nextInt();
				if(x > maxX) maxX = x;
				int y = file.nextInt();
				if(y > maxY) maxY = y;
				points.add(new Point(x, y));
			}
			
			char[][] mat = new char[maxY][maxX];
			points.stream().forEach(p -> mat[p.y-1][p.x-1] = 'X');
			
			//pretty much everything after this is formatting :(
			for(int y=maxY-1; y>=0; y--)
			{
				out.print(y+1+"|");
				for(char x : mat[y])
					out.print(x);
				out.println();
			}
			out.print("  ");
			for(int z=0; z<maxX; z++)
				out.print("_");
			out.print("\n  ");
			for(int x=1; x<=maxX; x++)
				out.print(x);
			out.println("\n=====");
		}
		
		file.close();
	}
}
