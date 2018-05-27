package mockContests.december2017.novice;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class Parallelogram {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/december2017/novice/data/judgesdata/parallelogram.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			String line = file.nextLine();
			for(int i = 0; i < 2 * line.length() - 1; ++i)
				if(i < line.length())
					System.out.println(String.join("", Collections.nCopies(line.length() - 1 - i, " "))
							+ line.substring(0, i + 1));
				else
					System.out.println(line.substring((i + 1) % line.length()));
			System.out.println();
		}
	}
}
