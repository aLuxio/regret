package mockContests.october2017;

import java.util.*;
import java.io.*;
public class Cheater {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/october2017/data/sampledata/cheater.dat"));
		int t = Integer.parseInt(file.nextLine());
		int[] freq = new int[4];
		for(; t > 0; --t)
			freq[6 - file.nextLine().length()]++;
		String[] colors = {"YELLOW", "BLACK", "BLUE", "RED"};
		Arrays.sort(colors, new Comparator<String>() {
			public int compare(String a, String b) {
				return freq[6 - b.length()] - freq[6 - a.length()];
			}
		});
		for(String col : colors)
			System.out.println(col);
	}
}
