package mockContests.january2018.advanced;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class CISgenerator {
	public static void main(String[] args) throws IOException {
		String[] names = new String[4945];
		Scanner file = new Scanner(new File("src/mockContests/january2018/data/names.txt"));
		for(int i = 0; i < names.length; ++i)
			names[i] = file.nextLine();
		Random randy = new Random();
		int datasets = randy.nextInt(15);
		System.out.println(datasets);
		HashMap<String, String> people;
		for(int dataset = 0; dataset < datasets; ++dataset) {
			people = new HashMap<>();
			int dnaLength = (100 + randy.nextInt(25)) % 31, numPeople = randy.nextInt(100);
			String pattern = makeDNA(randy, dnaLength);
			for(int p = 0; p < numPeople; ++p) {
				String name = names[randy.nextInt(names.length)];
				while(people.containsKey(name))
					name = names[randy.nextInt(names.length)];
				people.put(name, makeDNA(randy, dnaLength));
			}
			System.out.println(pattern);
			System.out.println(numPeople);
			for(Map.Entry<String, String> person : people.entrySet()) {
				System.out.printf("%s=%s%n", person.getKey(), person.getValue());
			}
		}
		file.close();
	}

	public static String makeDNA(Random randy, int length) {
		StringBuilder dna = new StringBuilder();
		for(int c = 0; c < length; ++c)
			dna.append("ATGC".charAt(randy.nextInt(4)));
		return dna.toString();
	}
}
