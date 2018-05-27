package mockContests.january2018.advanced;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Queue {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/january2018/Data/judgesdata/cue.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			int people = file.nextInt(), time = Integer.parseInt(file.nextLine().trim());
			String line = file.nextLine();
			for(int t = 0; t < time; ++t)
				line = line.replaceAll("BG", "GB");
			System.out.println(line);
		}
		file.close();
	}
}
