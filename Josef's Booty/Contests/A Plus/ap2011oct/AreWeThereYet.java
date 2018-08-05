package APlus.ap2011oct;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AreWeThereYet {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("thereyet.dat"));
		for(int T = file.nextInt(); T > 0; --T) {
			int hours = Integer.parseInt(file.findWithinHorizon("\\d+", 0)),
					minutes = 30 + Integer.parseInt(file.findWithinHorizon("\\d+", 0));
			System.out.format("%d hours %d minutes%n", hours + minutes / 60, minutes % 60);
		}
	}
}
