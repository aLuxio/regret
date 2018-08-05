package APlus.ap2010;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Submissions {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("submissions.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			System.out.println(file.nextLine().matches("(?i)today.*mlia") ? "VALID ENTRY"
					: "INCORRECT FORMATTING, TRY ANOTHER SUBMISSION");
		}
	}
}
