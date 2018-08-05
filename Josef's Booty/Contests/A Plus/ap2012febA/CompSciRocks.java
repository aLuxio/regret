package APlus.ap2012febA;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CompSciRocks {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("rocks.dat"));
		for(int T = file.nextInt(); T > 0; --T) {
			for(int a = file.nextInt(); a > 0; --a)
				System.out.println("Comp Sci Rocks!!");
			System.out.println();
		}
	}
}
