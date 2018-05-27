package Region.reg2017.A;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Brandon {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/Region/reg2017/data/judgedata/brandon.dat"));
		while(file.hasNext()) {
			int b = file.nextInt();
			System.out.printf((b & 1) == 1 ? "%.1f%n" : "%.0f%n", 1.0 * b * b);
		}
		file.close();
	}
}
