package mockContests.december2017.advanced;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SMA {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/december2017/advanced/data/sampledata/sma.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			String line = file.nextLine().trim();
			double result = line.contains(" ")
					? (Double.parseDouble(line.split(" ")[0]) + Double.parseDouble(line.split(" ")[1])) / 2
					: Math.cbrt((6.67408e-11 * 1.989e12 * Double.parseDouble(line) * Double.parseDouble(line))
							/ (4 * Math.PI * Math.PI));
			System.out.printf("%.3f%n", result);
		}
		file.close();
	}
}
