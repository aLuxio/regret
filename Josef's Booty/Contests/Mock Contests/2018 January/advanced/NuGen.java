package mockContests.january2018.advanced;

import java.util.Random;

public class NuGen {
	public static void main(String[] args) {
		Random randy = new Random();
		int datasets = randy.nextInt(25);
		System.out.println(datasets);
		for(int d = 0; d < datasets; ++d) {
			System.out.printf(randy.nextBoolean() ? "%f%n" : "%E%n", randy.nextInt(50) * randy.nextGaussian());
		}
	}
}
