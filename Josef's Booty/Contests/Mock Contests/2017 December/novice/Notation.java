package mockContests.december2017.novice;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Notation {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/december2017/novice/data/judgesdata/notation.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T)
			System.out.printf("%.2f%n", Double.parseDouble(file.nextLine().replace(" ", "e")));
	}
}
