package Region.reg2017.A;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Lisa {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/Region/reg2017/data/judgedata/lisa.dat"));
		HashMap<String, double[]> people = new HashMap<>();
		while(file.hasNext()) {
			String name = file.nextLine();
			double[] arr = new double[] { name.chars().sum(), name.toUpperCase().chars().sum(),
					name.toLowerCase().chars().sum(), 0 };
			arr[3] = (arr[0] + arr[1] + arr[2]) / (3 * name.length());
			people.put(name, arr);
		}
		people.keySet().stream().sorted(Comparator.comparing(x -> people.get(x)[3], Collections.reverseOrder()))
				.map(x -> String.format("%-10s %4.0f %4.0f %4.0f %5.2f", x, people.get(x)[0], people.get(x)[1],
						people.get(x)[2], people.get(x)[3]))
				.forEachOrdered(System.out::println);
		file.close();
	}
}
