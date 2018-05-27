package mockContests.january2018.advanced;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Reflection {
	public static void main(String[] args) throws IOException {

		// prepare to read the file
		Scanner file = new Scanner(new File("src/mockContests/january2017/Data/SampleData/reflection.dat"));
		String inLine = null;

		int T = Integer.parseInt(file.nextLine());

		// loop through test cases
		while(T-- > 0) {
			// read the number of lines
			int N = Integer.parseInt(file.nextLine());

			// max line length (for padding)
			int maxLineLength = 0;

			// temporary line storage
			String[] lines = new String[N];

			// loop through lines
			for(int i = 0; i < N; i++) {
				inLine = file.nextLine();

				// is this the longest line?
				if(inLine.length() > maxLineLength) {
					maxLineLength = inLine.length();
				}

				// store the line
				lines[i] = inLine;
			}

			// build a 2D array from the lines
			char[][] pic = new char[N][maxLineLength];

			// r = y and c = x
			for(int r = 0; r < N; r++) {
				String currentLine = lines[r];
				for(int c = 0; c < maxLineLength; c++) {
					if(c < currentLine.length()) {
						// there are still characters on this line
						pic[r][c] = currentLine.charAt(c);
					} else {
						// pad with spaces at the end of the line
						pic[r][c] = ' ';
					}
				}
			}

			// read what to do with the lines
			String reflectionType = file.nextLine();
			if(reflectionType.equals("X")) {
				// reflect up-down: just print the lines in reverse order
				for(int r = N - 1; r >= 0; r--) {
					System.out.println(lines[r]);
				}
			} else if(reflectionType.equals("Y")) {
				// reflect left-right: print lines in order, but reverse each one
				for(int r = 0; r < N; r++) {
					for(int c = maxLineLength - 1; c >= 0; c--) {
						System.out.print(pic[r][c]);
					}
					System.out.println();
				}
			} else if(reflectionType.equals("INVERSE")) {
				// switch x and y: write the columns as rows
				for(int r = 0; r < maxLineLength; r++) {
					for(int c = 0; c < N; c++) {
						System.out.print(pic[c][r]);
					}
					System.out.println();
				}
			}
		}

		// clean up
		file.close();
	}
}
