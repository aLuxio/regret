package mockContests.december2017.novice;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Addiply {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/december2017/novice/data/sampledata/addiply.dat"));
		for(int T = file.nextInt(); T > 0; --T) {
			int a = file.nextInt(), b = file.nextInt();
			System.out.println((a + b) + " " + (a * b));
		}
	}
}
