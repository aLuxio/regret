package APlus.ap2011oct;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class McSpeak {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("mcspeak.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			System.out.println("Mc" + file.nextLine());
		}
	}
}
