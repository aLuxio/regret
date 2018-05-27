package mockContests.january2018.advanced;

import java.util.Random;

public class MakeQueue {
	public static void main(String[] args) {
		Random randy = new Random();
		int datasets = randy.nextInt(15);
		System.out.println(datasets);
		for(int d = 0; d < datasets; ++d) {
			int people = randy.nextInt(20), time = 1 + randy.nextInt(15);
			System.out.println(people + " " + time);
			StringBuilder line = new StringBuilder();
			for(int p = 0; p < people; ++p) {
				line.append(randy.nextBoolean() ? "G" : "B");
			}
			System.out.println(line.toString());
		}
	}
}
