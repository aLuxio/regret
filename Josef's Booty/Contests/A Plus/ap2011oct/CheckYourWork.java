package APlus.ap2011oct;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CheckYourWork {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("check.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			int a = Integer.parseInt(file.nextLine()), b = Integer.parseInt(file.nextLine().substring(1));
			System.out.format("%4d%n x%d%n----%n%4d%n%4d%n----%n%4d%n%n", a, b, b % 10 * a, b / 10 * 10 * a, a * b);
		}
	}
}
