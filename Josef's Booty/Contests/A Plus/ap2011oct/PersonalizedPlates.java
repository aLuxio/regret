package APlus.ap2011oct;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PersonalizedPlates {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("plates.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			List<String> words = Arrays.stream(file.nextLine().split("\\s")).collect(Collectors.toList());
			for(int i = 0; String.join("", words).length() > 8
					&& String.join("", words).matches(".*[aeiou].*"); i = (i + 1) % words.size())
				words.set(i, words.get(i).replaceFirst("[aeiou]", ""));
			System.out.println(String.join("", words).substring(0, Math.min(String.join("", words).length(), 8)));
		}
	}
}
