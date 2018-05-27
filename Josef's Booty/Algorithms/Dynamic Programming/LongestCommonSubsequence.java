package algorithms.dynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		System.out.println(lcs("ABABC", "BABCA"));
		System.out.println(lcs("abcdxyz", "xyzabcd"));
		System.out.println(lcs("zxabcdezy", "yzabcdezx"));
		System.out.println(lcs("AGGTAB", "GXTXAYB"));
	}

	public static String lcs(String a, String b) {
		int al = a.length(), bl = b.length();
		String[][] lcs = new String[al + 1][bl + 1];
		for(String[] row : lcs)
			Arrays.fill(row, "");
		for(int i = 1; i <= al; ++i)
			for(int j = 1; j <= bl; ++j)
				lcs[i][j] = a.charAt(al - i) == b.charAt(bl - j) ? a.charAt(al - i) + lcs[i - 1][j - 1]
						: Stream.of(lcs[i][j - 1], lcs[i - 1][j]).max(Comparator.comparingInt(String::length)).get();
		return lcs[al][bl];
	}
}
