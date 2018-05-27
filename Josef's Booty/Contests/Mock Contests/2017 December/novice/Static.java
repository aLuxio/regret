package mockContests.december2017.novice;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Static {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/december2017/novice/data/judgesdata/static.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			String transmission = file.nextLine(), clean = transmission.replaceAll("[@#%]", "");
			System.out.printf("%s - %d removed%n", clean, transmission.length() - clean.length());
		}
	}

	public static String novice(String original) {
		String removed = "";
		for(char c : original.toCharArray())
			if("@#%".indexOf(c) == -1)
				removed += c;
		return removed;
	}
}
