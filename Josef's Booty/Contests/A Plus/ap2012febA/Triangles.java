package APlus.ap2012febA;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Triangles {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("triangles.dat"));
		int T = file.nextInt();
		file.nextLine();
		for(; T > 0; --T) {
			int size = file.nextInt();
			int start = file.nextLine().charAt(1);
			char[][] board = new char[size][size];
			for(int i = 0; i < size; ++i, start = (start == 'Z' ? 'A' : start + 1))
				for(int j = 0; j <= i; ++j)
					board[size - i - 1][size - j - 1] = (char) start;
			for(char[] row : board)
				System.out.println(String.valueOf(row).replace("" + (char) 0, " "));
			System.out.println();
		}
	}
}
