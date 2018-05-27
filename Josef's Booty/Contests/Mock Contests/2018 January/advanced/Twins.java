package mockContests.january2018.advanced;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Twins {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/january2018/Data/judgesdata/twins.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			int n = Integer.parseInt(file.nextLine());
			int[] coins = Arrays.stream(file.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
			int val = Arrays.stream(coins).sum();
			Arrays.sort(coins);
			int i = 0, sum = 0;
			for(; i < coins.length; ++i) {
				if(sum <= val) {
					sum += coins[i];
					val -= coins[i];
				} else
					break;
			}
			System.out.println(i);
		}
		file.close();
	}
}
