package APlus.ap2011oct;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CoolColors {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("coolcolors.dat"));
		while(file.hasNext())
			System.out.println(file.nextLine().replaceAll("[^b]", " "));
	}
}
