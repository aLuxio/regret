package APlus.ap2012febA;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Boxes {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("boxes.dat"));
		for(int T = file.nextInt(); T > 0; --T) {
			int size = file.nextInt();
			char[][] box = new char[size][size];
			for(int i = 0; i < box.length; ++i)
				for(int j = 0; j < box.length; ++j)
					if(Math.min(i, j) == 0 || Math.max(i, j) == size - 1)
						box[i][j] = '$';
					else
						box[i][j] = ' ';
			for(char[] row : box)
				System.out.println(String.valueOf(row));
			System.out.println();
		}
	}
}
