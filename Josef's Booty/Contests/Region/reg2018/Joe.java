package Region.reg2018;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Joe {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/Region/reg2018/data/studentdata/joe.dat"));
		while(file.hasNext()) {
			System.out.println(Arrays.stream(file.nextLine().toUpperCase().replaceAll("[^A-Z ]", "").split("\\s"))
					.distinct().sorted(Comparator.comparing(String::length).thenComparing(String::compareTo))
					.collect(Collectors.joining(" ")));
		}
		file.close();
	}
}
