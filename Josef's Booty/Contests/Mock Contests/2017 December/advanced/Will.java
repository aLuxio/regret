package mockContests.december2017.advanced;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Will {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/december2017/advanced/data/sampledata/will.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			int rows = file.nextInt(), cols = Integer.parseInt(file.nextLine().trim());
			String[] map = new String[rows];
			for(int i = 0; i < rows; ++i)
				map[i] = file.nextLine();
			System.out.printf("%.2f%n",
					(1.0 * Arrays.stream(map).flatMapToInt(str -> str.chars()).filter(x -> x == '#').count())
							/ (rows * cols) * 100);
		}
		file.close();
	}
}
