package mockContests.january2018.advanced;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CommonNames {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/january2018/data/judgesdata/common.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			HashMap<String, Integer> people = new HashMap<>();
			for(int l = Integer.parseInt(file.nextLine()); l > 0; --l)
				for(String s : file.nextLine().split("\\s"))
					people.merge(s, 1, Integer::sum);
			int maxCount = people.values().stream().mapToInt(Integer::intValue).max().getAsInt();
			System.out.println(people.entrySet().stream().filter(e -> e.getValue() == maxCount).map(e -> e.getKey())
					.sorted().collect(Collectors.joining(" ")));
		}
		file.close();
	}
}
