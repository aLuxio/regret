package mockContests.november2017;

import java.util.*;
import java.io.*;
public class Quadrilateral {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/november2017/data/judgesdata/quadrilateral.dat"));
		int T = file.nextInt();
		file.nextLine();
		for(; T > 0; --T) {
			int columns = file.nextInt(), rows = file.nextInt();
			for(int row = 0; row < rows; ++row) {
				for(int col = 0; col < columns; ++col)
					System.out.print("X");
				System.out.println();
			}
			System.out.println();
		}
		file.close();
	}
}
