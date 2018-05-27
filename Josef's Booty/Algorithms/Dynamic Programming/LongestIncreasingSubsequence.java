package algorithms.dynamicProgramming;

import java.util.*;
import java.util.stream.Stream;
import java.io.*;
public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(LISbyLCS(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15})));
		System.out.println(Arrays.toString(LISbyLCS(new int[]{3, 10, 2, 1, 20})));
		System.out.println(Arrays.toString(LISbyLCS(new int[]{3, 2})));
		System.out.println(Arrays.toString(LISbyLCS(new int[]{50, 3, 10, 7, 40, 80})));
	}
	public static int[] LISbyLCS(int[] arr) {
		return lcs(arr, Arrays.stream(arr).distinct().sorted().toArray());
	}
	public static int[] lcs(int[] a, int[] b) {
		int al = a.length, bl = b.length;
		String[][] lcs = new String[al + 1][bl + 1];
		for(String[] row : lcs)
			Arrays.fill(row, "");
		for(int i = 1; i <= al; ++i)
			for(int j = 1; j <= bl; ++j)
				lcs[i][j] = a[al - i] == b[bl - j] ? a[al - i] + " " + lcs[i-1][j-1] : Stream.of(lcs[i-1][j], lcs[i][j-1]).max(Comparator.<String>comparingInt(str -> str.split("\\s").length).thenComparing(String::length)).get();
		return Arrays.stream(lcs[al][bl].split("\\s")).mapToInt(Integer::parseInt).toArray();
	}
}
