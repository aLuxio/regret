package mockContests.december2017.novice;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class DeltaInversion {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/december2017/novice/data/sampledata/delta.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; T--) {
			int[] nums = Arrays.stream(file.nextLine().split("\\s")).skip(1).mapToInt(Integer::parseInt).toArray();
			int[] delta = IntStream.range(0, nums.length - 1).map(x -> nums[x] - nums[x + 1]).toArray();
			Arrays.setAll(nums, x -> nums[x] = x != 0 ? nums[x - 1] + delta[x - 1] : nums[x]);
			System.out.println(Arrays.toString(nums).replaceAll("[\\[\\],]", ""));
		}
	}
}
