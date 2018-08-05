package APlus.ap2011oct;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Scanner;

public class HighAndLow {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("highandlow.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			IntSummaryStatistics i = Arrays.stream(file.nextLine().split("\\s")).mapToInt(Integer::parseInt)
					.summaryStatistics();
			System.out.format("high = %d low = %d%n", i.getMax(), i.getMin());
		}
	}
}
