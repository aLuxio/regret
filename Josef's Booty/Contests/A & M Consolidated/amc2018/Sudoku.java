package amConsolidated.amc2018;

// i should really write a better solution to this

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Sudoku {
	static int[][] board;

	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("sudoku.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			board = new int[9][9];
			for(int i = 0; i < 9; ++i)
				board[i] = Arrays.stream(file.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
			solve();
			Arrays.stream(board).map(x -> Arrays.stream(x).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
					.forEachOrdered(System.out::println);
			if(file.hasNext()) {
				file.nextLine();
				System.out.println();
			}
		}
		file.close();
	}

	public static boolean solve() {
		int[] next = unassigned();
		if(next[0] == -1)
			return true;
		for(int val = 1; val <= 9; ++val) {
			if(isValid(next[0], next[1], val)) {
				board[next[0]][next[1]] = val;
				if(solve())
					return true;
				board[next[0]][next[1]] = 0;
			}
		}
		return false;
	}

	public static int[] unassigned() {
		for(int i = 0; i < 9; ++i)
			for(int j = 0; j < 9; ++j)
				if(board[i][j] == 0)
					return new int[] { i, j };
		return new int[] { -1, -1 };
	}

	public static boolean isValid(int i, int j, int val) {
		for(int jj = 0; jj < 9; jj++)
			if(board[i][jj] == val)
				return false;
		for(int ii = 0; ii < 9; ii++)
			if(board[ii][j] == val)
				return false;
		int boxRow = i - i % 3;
		int boxColumn = j - j % 3;
		for(int ii = 0; ii < 3; ii++)
			for(int jj = 0; jj < 3; jj++)
				if(board[boxRow + ii][boxColumn + jj] == val)
					return false;
		return true;
	}
}
