package Region.reg2018;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Ramya {
	public static void main(String[] args) throws IOException {
		System.out
				.println(Files
						.lines(Paths
								.get("src/Region/reg2018/data/judgeData/ramya.dat"))
						.map(line -> line.trim().chars().sorted().mapToObj(x -> (char) x).collect(Collectors.toList()))
						.map(Ramya::of)
						.map(stream -> stream.map(p -> p.map(let -> "" + let).collect(Collectors.joining())).distinct()
								.limit(30).collect(Collectors.joining("\n")))
						.collect(Collectors.joining("\n=====\n", "", "\n=====")));
	}

	public static IntFunction<Integer> factorial = x -> IntStream.rangeClosed(2, x).reduce(1, (a, b) -> a * b);

	public static <T> Stream<Stream<T>> of(final List<T> items) {
		return IntStream.range(0, factorial.apply(items.size())).mapToObj(i -> permutation(i, items).stream());
	}

	private static <T> List<T> permutation(final int count, final LinkedList<T> input, final List<T> output) {
		if(input.isEmpty())
			return output;
		int fact = factorial.apply(input.size() - 1);
		output.add(input.remove(count / fact));
		return permutation(count % fact, input, output);
	}

	private static <T> List<T> permutation(final int count, final List<T> items) {
		return permutation(count, new LinkedList<>(items), new ArrayList<>());
	}
}
