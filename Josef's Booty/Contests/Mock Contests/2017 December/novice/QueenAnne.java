package mockContests.december2017.novice;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class QueenAnne {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/december2017/novice/data/judgesdata/queenanne.dat"));
		String line;
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T)
			System.out.println(((line = file.nextLine()).matches(".*(.)\\1.*") ? "likes " : "dislikes ") + line);
	}
}
