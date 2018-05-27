package mockContests.december2017.advanced;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Curb {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/december2017/advanced/data/sampledata/curb.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			Set<String> villiam = Arrays.stream(file.nextLine().split("\\s")).collect(Collectors.toSet()),
					colton = Arrays.stream(file.nextLine().split("\\s")).collect(Collectors.toSet()),
					colten = Arrays.stream(file.nextLine().split("\\s")).collect(Collectors.toSet());
			colton.retainAll(villiam);
			colten.retainAll(villiam);
			System.out.println(colton.size() > colten.size() ? "Colton"
					: colton.size() < colten.size() ? "Colten" : "Sneak one in!");
		}
		file.close();
	}
}
