package mockContests.january2018.advanced;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Nu {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/january2018/Data/judgesdata/nu.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			System.out.printf("%.2E%n", 3e8 / file.nextDouble());
		}
		file.close();
	}
}
