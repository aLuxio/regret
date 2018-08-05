package APlus.ap2011oct;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SaveLikeNoOneElse {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("save.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			double P = file.nextDouble(), n = file.nextDouble(), r = file.nextDouble();
			System.out.format("$%,.2f%n", P * (Math.pow(1 + r / 100 / 12, n) - 1) / (r / 100 / 12));
		}
	}
}
