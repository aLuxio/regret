package mockContests.december2017.novice;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Mars {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/december2017/novice/data/judgesdata/mars.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			double distance = file.nextDouble() * 1000000, speed = file.nextDouble();
			double time = distance / speed * 3600;
			int days = (int) (time / 3600 / 24);
			time %= 3600 * 24;
			int hours = (int) (time / 3600);
			time %= 3600;
			int minutes = (int) (time / 60);
			time %= 60;
			System.out.format("Time to Mars: %d days, %d hours, %d minutes, %.0f seconds%n", days, hours, minutes,
					time);
		}
	}
}
