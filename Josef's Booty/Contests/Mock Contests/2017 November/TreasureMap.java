package mockContests.november2017;

import java.util.*;
import java.io.*;
public class TreasureMap {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/november2017/data/judgesdata/treasure.dat"));
		int T = file.nextInt();
		file.nextLine();
		for(; T > 0; --T) {
			char[][] map = new char[10][10];
			for(int row = 0; row < 10; ++row)
				map[row] = file.nextLine().toCharArray();
			file.nextLine();
			int numIslands = 0;
			for(int i = 0; i < 10; ++i)
				for(int j = 0; j < 10; ++j)
					if(map[i][j] == '#' && isIsland(map, i, j))
						numIslands++;
			System.out.println(numIslands);
		}
		file.close();
	}
	public static int[] mx = {1, 0, -1, 0}, my = {0, 1, 0, -1};
	public static boolean isIsland(char[][] map, int i, int j) {
		if(Math.min(i, j) == 0 || Math.max(i, j) == 9)
			return false;
		map[i][j] = '*';
		boolean island = true;
		for(int q = 0; q < 4; ++q)
			if(i + mx[q] >= 0 && i + mx[q] < 10 && j + my[q] >= 0 && j + my[q] < 10 && map[i+mx[q]][j+my[q]] == '#')
				island &= isIsland(map, i + mx[q], j + my[q]);
		return island;
	}
}
