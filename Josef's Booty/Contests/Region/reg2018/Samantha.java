package Region.reg2018;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Samantha {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/Region/reg2018/data/studentData/samantha.dat"));
		while(file.hasNext()) {
			double subtotal = Arrays.stream(file.nextLine().split("\\s")).mapToDouble(Double::parseDouble).sum();
			System.out.printf("Subtotal: $%7.2f%nTax     : $%7.2f%nTotal   : $%7.2f%n=====%n", subtotal,
					subtotal * .0825,
					subtotal * 1.0825);
		}
		file.close();
	}
}
