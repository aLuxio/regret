package State.st2018;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Dennis {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/State/st2018/data/judgesData/dennis.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			int w = Integer.parseInt(file.nextLine());
			String[] words = IntStream.range(0, w).mapToObj(x -> file.nextLine()).toArray(String[]::new);
			int max = Arrays.stream(words).mapToInt(String::length).max().getAsInt();
			for(int i = 0; i < max; ++i) {
				for(String s : words)
					System.out.print(i < s.length() ? s.charAt(i) : " ");
				System.out.println();
			}
			System.out.println("***");
		}
		file.close();
	}
}
