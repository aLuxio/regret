package mockContests.january2018.advanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TwinsGen {
	public static void main(String[] args) {
		Random randy = new Random();
		int datasets = randy.nextInt(15);
		System.out.println(datasets);
		for(int d = 0; d < datasets; ++d) {
			int coins = randy.nextInt(100);
			List<String> c = new ArrayList<>();
			System.out.println(coins);
			for(int i = 0; i < coins; ++i)
				c.add("" + randy.nextInt(100));
			Collections.shuffle(c);
			System.out.println(String.join(" ", c));
		}
	}
}
