package mockContests.december2017.novice;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SMA {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/december2017/novice/data/judgesdata/sma.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			double ap = file.nextDouble(), pe = file.nextDouble(), t = file.nextDouble();
			System.out.printf("%.3f%n%.3f%n", (ap + pe) / 2,
					Math.cbrt((6.667408e-3 * 1.989e6 * t * t) / (4 * Math.PI * Math.PI)));
		}
	}
}
