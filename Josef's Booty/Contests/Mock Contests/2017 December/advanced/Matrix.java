package mockContests.december2017.advanced;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Matrix {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/december2017/advanced/data/sampledata/matrix.dat"));
		for(int T = file.nextInt(); T > 0; --T) {
			int[] nums = new int[file.nextInt()];
			for(int i = 0; i < nums.length; ++i)
				nums[i] = file.nextInt();
			System.out.println(IntStream.range(0, nums.length).boxed().sorted(Comparator.comparing(x -> nums[x]))
					.map(x -> Integer.toString(x)).collect(Collectors.joining(" ")));
		}
		file.close();
	}
}
