package amConsolidated.amc2018;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SortingStudents {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("students.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			TreeMap<Integer, String> people = new TreeMap<>(Collections.reverseOrder());
			for(int p = Integer.parseInt(file.nextLine()); p > 0; --p) {
				String[] in = file.nextLine().split("\\s");
				people.put(Integer.parseInt(in[1]), in[0]);
			}
			System.out.println(people.entrySet().stream().map(e -> e.getValue() + " " + e.getKey())
					.collect(Collectors.joining("\n")));
			if(file.hasNext())
				System.out.println();
		}
		file.close();
	}
}
