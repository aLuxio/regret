package State.st2017;
import java.util.*;
import java.io.*;
public class Keerthi
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("src\\State\\st2017\\data\\keerthi.txt"));
		int T = file.nextInt();
		file.nextLine();
		for(; T > 0; T--)
		{
			char[][] map = new char[10][10];
			for(int i = 0; i < 10; i++)
				map[i] = file.nextLine().toCharArray();
			file.nextLine();
			int islands = 0;
			for(int i = 0; i < 10; i++)
				for(int j = 0; j < 10; j++)
					if(map[i][j] == '#' && remove(map, i, j))
						islands++;
			System.out.println(islands);
		}
	}
	public static int[] mx = {1, 0, -1, 0}, my = {0, 1, 0, -1};
	public static boolean remove(char[][] map, int x, int y)
	{
		if(map[x][y] != '#')
			return true;
		map[x][y] = '.';
		boolean r = true;
		for(int q = 0; q < 4; q++)
			if(x+mx[q]<0 || x+mx[q]>9 || y+my[q]<0 || y+my[q]>9)
				r = false;
			else
				r &= remove(map, x+mx[q], y+my[q]);
		return r;
	}
}
