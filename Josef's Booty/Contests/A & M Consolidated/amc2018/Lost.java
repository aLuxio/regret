package amConsolidated.amc2018;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Lost {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("lost.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			int r = file.nextInt(), c = Integer.parseInt(file.nextLine().trim());
			char[][] maze = new char[r][];
			for(int i = 0; i < r; ++i)
				maze[i] = file.nextLine().toCharArray();
			int ans = willsmaze(maze);
			System.out.println(ans == -1 ? "Not Possible" : ans);
		}
		file.close();
	}

	static int[] mx = { 1, 0, -1, 0 }, my = { 0, 1, 0, -1 };

	public static int willsmaze(char[][] maze) {
		ArrayDeque<Point> totallynotastack = new ArrayDeque<>();
		G: for(int i = 0; i < maze.length; ++i)
			for(int j = 0; j < maze[0].length; ++j)
				if(maze[i][j] == 'S') {
					maze[i][j] = 'z' + 1;
					totallynotastack.add(new Point(i, j));
					break G;
				}
		while(!totallynotastack.isEmpty()) {
			Point p = totallynotastack.pop();
			for(int q = 0; q < 4; ++q)
				if(p.x + mx[q] < 0 || p.x + mx[q] > maze.length - 1 || p.y + my[q] < 0
						|| p.y + my[q] > maze[0].length - 1)
					continue;
				else if(maze[p.x + mx[q]][p.y + my[q]] == 'E')
					return maze[p.x][p.y] - 'z';
				else if(maze[p.x + mx[q]][p.y + my[q]] == '.') {
					totallynotastack.add(new Point(p.x + mx[q], p.y + my[q]));
					maze[p.x + mx[q]][p.y + my[q]] = (char) (maze[p.x][p.y] + 1);
				}
		}
		return -1;
	}
}
