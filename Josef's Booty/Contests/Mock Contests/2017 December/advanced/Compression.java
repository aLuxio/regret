package mockContests.december2017.advanced;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Compression {
	public static void main(String[] args) throws IOException {
		Files.lines(Paths.get("src/mockContests/december2017/advanced/data/sampledata/compression.dat")).skip(1)
				.map(s -> s.split("(?<=(.))(?!\\1)")).map(arr -> Arrays.stream(arr)
						.map(y -> "" + y.charAt(0) + (y.length() > 1 ? y.length() : "")).collect(Collectors.joining()))
				.forEachOrdered(System.out::println);
	}
}
