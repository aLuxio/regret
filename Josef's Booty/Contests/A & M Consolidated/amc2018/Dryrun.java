package amConsolidated.amc2018;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Dryrun {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("dryrun.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			System.out.println("Welcome to " + file.nextLine() + ".");
		}
		file.close();
	}
}
