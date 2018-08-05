package APlus.ap2011oct;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DebtIsDumb {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("debt.dat"));
		while(file.hasNext())
			System.out.println(file.nextDouble() * 0.9 >= file.nextDouble() ? "fleece" : "beater");
	}
}
