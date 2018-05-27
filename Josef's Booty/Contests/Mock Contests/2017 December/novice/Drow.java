package mockContests.december2017.novice;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Drow {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/december2017/novice/data/judgesdata/drow.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			String line = file.nextLine();
			StringBuilder str = new StringBuilder(
					Arrays.stream(line.toLowerCase().split("(?i)((?<=[a-z])(?![a-z])|(?<![a-z])(?=[a-z]))"))
							.map(s -> s.matches("[a-z]+") ? new StringBuilder(s).reverse().toString() : s)
							.collect(Collectors.joining()));
			IntStream.range(0, line.length()).filter(x -> Character.isUpperCase(line.charAt(x)))
					.forEach(x -> str.setCharAt(x, Character.toUpperCase(str.charAt(x))));
			System.out.println(str);
		}
	}
}
