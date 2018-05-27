package mockContests.january2018.advanced;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Cats {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/january2018/data/judgesdata/cats.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			int[] nums = Arrays.stream(file.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
			int gcf = arrayGcf(nums), paneCount = Arrays.stream(nums).map(x -> x / gcf).map(x -> x * x).sum();
			System.out.printf("%.4f %d%n", Math.sqrt(2) * gcf, paneCount);
		}
		file.close();
	}

	public static int gcf(int a, int b) {
		return Math.min(a, b) == 0 ? Math.max(a, b) : gcf(b, a % b);
	}

	public static int arrayGcf(int[] nums) {
		Arrays.sort(nums);
		int gcf = nums[0];
		for(int i = 1; i < nums.length; ++i)
			gcf = gcf(gcf, nums[i]);
		return gcf;
	}
}
