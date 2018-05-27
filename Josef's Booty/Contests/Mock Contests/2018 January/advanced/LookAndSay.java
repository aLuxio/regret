package mockContests.january2018.advanced;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LookAndSay {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/january2018/data/judgesData/look.dat"));
		String[] seq = new String[31];
		Arrays.setAll(seq,
				x -> x < 2 ? "1"
						: Arrays.stream(seq[x - 1].split("(?<=(.))(?!\\1)")).map(s -> "" + s.length() + s.charAt(0))
								.collect(Collectors.joining()));
		for(int T = file.nextInt(); T > 0; --T) {
			System.out.println(seq[file.nextInt()]);
		}
		file.close();
	}
}
