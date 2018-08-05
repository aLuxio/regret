package APlus.ap2012febA;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Backwards {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("back.dat"));
		int T = file.nextInt();
		file.nextLine();
		for(; T > 0; --T) {
			String s = file.nextLine();
			System.out.println(s.equals(new StringBuilder(s).reverse().toString()) ? "SAME" : "NOT SAME");
		}
	}
}
