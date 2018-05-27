package algorithms.strings;

public class LongestCommonSubstring {
	
	public static void main(String[] args) {
		System.out.println(longestCommonSubstring("abcdxyz", "xyzabcd"));
		System.out.println(longestCommonSubstring("zxabcdezy", "yzabcdezx"));
	}
	
	public static String longestCommonSubstring(String a, String b)
	{
		if(a == null) {
			throw new IllegalArgumentException("String (a) must not be null");
		}
		if(b == null) {
			throw new IllegalArgumentException("String (b) must not be null");
		}
		if(a.isEmpty() || b.isEmpty()) {
			return new String();
		}
		int[][] dp = new int[a.length() + 1][b.length() + 1];
		int suffixEnd = 0, maxLen = -1;
		for(int i = 1; i < dp.length; ++i) {
			for(int j = 1; j < dp[0].length; ++j) {
				if(a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
					if(dp[i][j] > maxLen) {
						maxLen = dp[i][j];
						suffixEnd = i;
					}
				}
			}
		}
		return a.substring(suffixEnd - maxLen, suffixEnd);
	}
}
