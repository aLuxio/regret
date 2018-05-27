package mockContests.december2017.advanced;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CatScan {
	public static void main(String[] args) throws IOException {
		Files.lines(Paths.get("src/mockContests/december2017/advanced/data/judgesdata/cat.dat")).skip(1)
				.map(str -> str.split("(?<=\")\\s(?!\")"))
				.map(arr -> arr[0].substring(1, arr[0].length() - 1) + " is "
						+ (arr[0].equals("\"Will\"")
								|| Integer.parseInt(arr[1].substring(arr[1].lastIndexOf(" ") + 1)) >= 1975 ? "COOL!"
										: "a DINOSAUR!"))
				.forEachOrdered(System.out::println);
	}
}
