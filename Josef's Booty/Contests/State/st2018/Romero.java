package State.st2018;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Romero {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/State/st2018/data/judgesData/romero.dat")).useDelimiter("[/ ]");
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MMMM d, yyyy");
		System.out.printf("%-19s%-11s%-11s%-6s%-6s%-7s%-9s|%n", "Date", "Attendance", "Gross", "ATP", "STP", "Adults",
				"Stu/Child");
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			int m = file.nextInt(), d = file.nextInt(), y = file.nextInt(), attendance = file.nextInt();
			double gross = file.nextDouble(), adultPrice = file.nextDouble(),
					studentPrice = Double.parseDouble(file.nextLine().trim());
			System.out.printf("%-19s%-11d$%,-10.2f$%-5.2f$%-5.2f%-7d%-9d|%n", format.format(LocalDate.of(y, m, d)),
					attendance, gross, adultPrice, studentPrice,
					(int) Math.ceil(((studentPrice * attendance - gross) / (studentPrice - adultPrice))),
					attendance - (int) Math.ceil(((studentPrice * attendance - gross) / (studentPrice - adultPrice))));
		}
		file.close();
	}
}
