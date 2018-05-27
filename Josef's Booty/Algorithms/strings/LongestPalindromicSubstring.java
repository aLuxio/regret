package algorithms.strings;

import java.util.Arrays;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(lps("badad"));
		System.out.println(lps("cbbd"));
		System.out.println(lps("abaccddccefe"));
		System.out.println(lps("HYTBCABADEFGHABCDEDCBAGHTFYW1234567887654321ZWETYGDE"));
		System.out.println(lps("a"));
	}
	public static String lps(String line) {
		if(line == null)
			throw new IllegalArgumentException("Arguments cannot be null");
		if(line.isEmpty())
			return new String();
		char[] text = ('\0' + line.replaceAll("", ""+'\1') + Character.toString('\2')).toCharArray();
		int[] lengths = new int[text.length];
		int center = 0, right = 0, maxCenter = 0, maxLength = 0;
		for(int i = 1; i < text.length - 1; ++i) {
			int mirror = 2 * center - i;
			if(right > i)
				lengths[i] = Math.min(right - i, lengths[mirror]);
			while(text[i + (1 + lengths[i])] == text[i - (1 + lengths[i])])
				lengths[i]++;
			if(i + lengths[i] > right) {
				center = i;
				right = i + lengths[i];
			}
			if(lengths[i] > lengths[maxCenter]) {
				maxCenter = i;
				maxLength = lengths[i];
			}
		}
		int le = (maxCenter - maxLength) / 2,  ri = le + maxLength;
		return line.substring(le, ri);
	}
}

