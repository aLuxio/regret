package APlus.ap2011oct;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Satisfied {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("satisfied.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			int[] c = new int[2];
			file.nextLine().chars().filter(x -> x == 'p' || x == 'm').forEach(x -> c[x & 1]++);
			System.out.println(c[0] == c[1] ? "Satisfied!"
					: "Eat " + Math.abs(c[0] - c[1]) + " more " + (c[0] > c[1] ? "M&M's" : "peanuts"));
		}
	}
}
