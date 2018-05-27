package mockContests.november2017;

import java.util.*;
import java.io.*;
public class Tacocat {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/november2017/data/judgesdata/tacocat.dat"));
		int T = file.nextInt();
		file.nextLine();
		for(; T > 0; --T) {
			String line = file.nextLine();
			String longestPalindrome = "";
			for(int start = 0; start < line.length(); ++ start) {
				for(int end = start + 1; end < line.length() + 1; ++end) {
					String possiblePalindrome = line.substring(start, end);
					boolean isPalindrome = true;
					for(int i = 0; i < possiblePalindrome.length(); ++i)
						if(possiblePalindrome.charAt(i) != possiblePalindrome.charAt(possiblePalindrome.length() - 1 - i))
							isPalindrome = false;
					if(isPalindrome && possiblePalindrome.length() > longestPalindrome.length())
						longestPalindrome = possiblePalindrome;
				}
			}
			System.out.println(longestPalindrome);
		}
		file.close();
	}
}
