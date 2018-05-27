package Region.reg2015.A;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Codebreaker {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/Region/reg2015/data/studentdata/codebreaker.dat"));
		int a = file.nextInt(), b = Integer.parseInt(file.nextLine().trim());
		HashSet<String> dict = new HashSet<>();
		for(int i = 0; i < a; ++i)
			dict.add(file.nextLine().trim());
		for(int i = 0; i < b; ++i) {
			String[] sentence = file.nextLine().split("\\s");
			thing(dict, sentence, 0);
		}
	}

	public static String thing(HashSet<String> dict, String[] words, int w) {
		HashSet<String> sameLength = new HashSet<>();
		dict.stream().filter(x -> x.length() == words[w].length()).forEach(sameLength::add);
		G: for(String s : sameLength) {
			char[] map = new char[26];
			for(int i = 0; i < s.length(); ++i)
				if(map[i] > 0 && map[i] != s.charAt(i))
					continue G;
				else
					map[i] = s.charAt(i);
		}
		return "me";
	}
}
