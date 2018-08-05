package APlus.ap2011oct;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;

public class NoteInterception {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("note.dat"));
		char[][] chart = new char[file.nextInt()][file.nextInt()];
		file.nextLine();
		for(int i = 0; i < chart.length; ++i)
			chart[i] = file.nextLine().toCharArray();
		int q = file.nextInt();
		file.nextLine();
		for(int i = 0; i < q; ++i) {
			char[] target = file.nextLine().toCharArray();
			char[][] map = new char[chart.length][chart[0].length];
			for(int x = 0; x < chart.length; ++x)
				map[x] = String.valueOf(chart[x]).toCharArray();
			System.out.println(willsmaze(map, target[0], target[1], target[2]));
		}
	}

	public static String willsmaze(char[][] map, char from, char to, char dont) {
		int[] mx = { 1, 0, -1, 0 }, my = { 0, 1, 0, -1 };
		ArrayDeque<State> totallynotastack = new ArrayDeque<>();
		for(int i = 0; i < map.length; i++)
			for(int j = 0; j < map[0].length; j++)
				if(map[i][j] == from) {
					totallynotastack.add(new State(i, j, false));
					map[i][j] = '.';
					break;
				}
		State ans = null;
		boolean lower = Character.isLowerCase(from);
		while(!totallynotastack.isEmpty()) {
			State p = totallynotastack.pop();
			for(int q = 0; q < 4; ++q)
				if(p.l.x + mx[q] < 0 || p.l.x + mx[q] > map.length - 1 || p.l.y + my[q] < 0
						|| p.l.y + my[q] > map[0].length - 1
						|| lower != Character.isLowerCase(map[p.l.x + mx[q]][p.l.y + my[q]])) {
					map[p.l.x][p.l.y] = '.';
					continue;
				} else if(map[p.l.x + mx[q]][p.l.y + my[q]] == dont) {
					totallynotastack.add(new State(p.l.x + mx[q], p.l.y + my[q], true));
					map[p.l.x][p.l.y] = '.';
				} else if(map[p.l.x + mx[q]][p.l.y + my[q]] == to) {
					if(ans == null || (ans.inter && !p.inter))
						ans = new State(p.l.x + mx[q], p.l.y + my[q], p.inter);
					map[p.l.x][p.l.y] = '.';
				} else if(Character.isLetter(map[p.l.x + mx[q]][p.l.y + my[q]])) {
					totallynotastack.add(new State(p.l.x + mx[q], p.l.y + my[q], p.inter));
					map[p.l.x][p.l.y] = '.';
				}
		}
		return ans == null ? "IMPOSSIBLE" : ans.inter ? "INTERCEPTED" : "POSSIBLE";
	}

	static class State {
		boolean inter;
		Point l;

		public State(int x, int y, boolean i) {
			l = new Point(x, y);
			inter = i;
		}

		public String toString() {
			return "(" + l.x + "," + l.y + ") " + inter;
		}
	}
}
