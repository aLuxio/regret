package mockContests.november2017;

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ShiftingGears {
	public static void main(String[] args) throws IOException {
		patrician();
	}

	public static void plebeian() throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/november2017/data/judgesdata/gears.dat"));
		String shift = "~!@#$%^&*()_+{}|:\"<>?";
		int T = file.nextInt();
		file.nextLine();
		for(; T > 0; --T) {
			String line = " " + file.nextLine();
			int count = 0;
			for(int i = 1; i < line.length(); ++i)
				if((Character.isUpperCase(line.charAt(i)) || shift.indexOf(line.charAt(i)) != -1) && !(Character.isUpperCase(line.charAt(i - 1)) || shift.indexOf(line.charAt(i - 1)) != -1))
					count++;
			System.out.format("The shift key was pressed %d times.%n", count);
		}
		file.close();
	}

	public static void patrician() throws IOException {
		Files.lines(Paths.get("src/mockContests/november2017/data/judgesdata/gears.dat")).skip(1)
				.map(str -> Arrays.stream(str.split("[^A-Z~!@#$%^&*()_+{}|:\"<>?]+")).filter(s -> !s.isEmpty())
						.toArray())
				.map(Array::getLength).map(len -> String.format("The shift key was pressed %d times.", len))
				.forEachOrdered(System.out::println);
	}
}
