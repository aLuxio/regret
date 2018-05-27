package State.st2018;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Leonardo {
	public static void main(String[] args) throws IOException {
		Files.lines(Paths.get("src/State/st2018/data/judgesData/leonardo.dat")).map(String::toUpperCase)
				.map(s -> s.replaceAll(
						"(?:(?=.+=)(?<=[A-Z])[A-Z]+)|(?:[A-Z]+(?=[A-Z])(?!.+=))|(?:(?<=[A-Z])\\s(?=[A-Z]))", ""))
				.forEachOrdered(System.out::println);
	}
}
