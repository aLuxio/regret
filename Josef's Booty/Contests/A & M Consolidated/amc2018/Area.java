package amConsolidated.amc2018;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Area {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("area.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			BigDecimal a = file.nextBigDecimal(), b = file.nextBigDecimal();
			System.out.println(a.multiply(b).setScale(2, RoundingMode.HALF_UP));
		}
		file.close();
	}
}
