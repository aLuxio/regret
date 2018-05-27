package mockContests.january2018.advanced;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class CSI {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/january2018/data/judgesdata/csi.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			TreeSet<String> mins = new TreeSet<>();
			String pattern = file.nextLine();
			int people = Integer.parseInt(file.nextLine());
			int minDist = pattern.length();
			for(int i = 0; i < people; ++i) {
				String[] in = file.nextLine().split("=");
				int ham = hamming(pattern, in[1]);
				if(ham < minDist) {
					minDist = ham;
					mins = new TreeSet<>();
					mins.add(in[0]);
				} else if(ham == minDist) {
					mins.add(in[0]);
				}
			}
			System.out.println(String.join(",", mins));
		}
		file.close();
	}

	public static int hamming(String a, String b) {
		return (int) IntStream.range(0, a.length()).filter(x -> a.charAt(x) != b.charAt(x)).count();
	}
}
