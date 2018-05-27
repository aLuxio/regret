package mockContests.january2018.advanced;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Lucky {
	public static void main(String[] args) throws IOException {
		Set<Integer> luckyBelow1000 = new HashSet<>();
		for(int i = 4; i < 1000; ++i)
			if(Integer.toString(i).matches("[47]+"))
				luckyBelow1000.add(i);
		Scanner file = new Scanner(new File("src/mockContests/january2018/Data/judgesdata/lucky.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			int n = file.nextInt();
			boolean divisible = false;
			for(int lucky : luckyBelow1000)
				if(n % lucky == 0)
					divisible = true;
			System.out.println(divisible ? "YES" : "NO");
		}
		file.close();
	}
}
