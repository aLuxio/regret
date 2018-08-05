package amConsolidated.amc2018;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

public class Coins {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("coins.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			System.out.println(makeChange(file.nextInt(), Integer.parseInt(file.nextLine().trim()),
					Arrays.stream(file.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray()) ? "Possible"
							: "Not Possible");
		}
		file.close();
	}

	public static boolean makeChange(int G, int n, int[] coins) {
		BitSet dp = new BitSet(G + 1);
		dp.set(0);
		for(int i = 1; i <= G; ++i)
			for(int c : coins)
				if(c <= i && dp.get(i - c))
					dp.set(i);
		return dp.get(G);
	}
}
