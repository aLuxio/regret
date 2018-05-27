package Region.reg2015;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Pattern {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("Src/region/reg2015/data/studentdata/pattern.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			String pattern = file.nextLine(), word[] = file.nextLine().split("\\s");
			HashMap<Character, String> words = new HashMap<>();
			boolean True = true;
			for(int i = 0; i < pattern.length(); ++i)
				if(!words.containsKey(pattern.charAt(i)) && !words.containsValue(word[i])
						|| words.containsKey(pattern.charAt(i)) && words.get(pattern.charAt(i)).equals(word[i]))
					words.put(pattern.charAt(i), word[i]);
				else
					True = false;
			System.out.println(True ? "Matches" : "Does Not Match");
		}
		file.close();
	}
}
