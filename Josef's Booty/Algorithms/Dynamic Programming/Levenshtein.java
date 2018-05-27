package algorithms.strings.editDistance;

public class Levenshtein {

	public static void main(String[] args) {
		System.out.println(levenshtein("kitten", "sitting") + " " + modifiedLevenshtein("kitten", "sitting"));
		System.out.println(levenshtein("test", "test") + " " + modifiedLevenshtein("test", "test"));
		System.out.println(levenshtein("test", "tent") + " " + modifiedLevenshtein("test", "tent"));
		System.out.println(levenshtein("gumbo", "gambol") + " " + modifiedLevenshtein("gumbo", "gambol"));
		System.out.println(
				levenshtein("levenshtein", "meilenstein") + " " + modifiedLevenshtein("levenshtein", "meilenstein"));
		System.out.println(levenshtein(null, "null") + " " + modifiedLevenshtein(null, "null"));
	}
	
	// generally just use this approach
	public static int levenshtein(String a, String b) {
		if (a == null)
			throw new IllegalArgumentException("String (a) cannot not be null");
		if (b == null)
			throw new IllegalArgumentException("String (b) cannot not be null");

		int m = a.length(), n = b.length();

		if (a.isEmpty())
			return n;
		if (b.isEmpty())
			return m;

		int[][] dis = new int[m + 1][n + 1];
		for (int i = 0; i <= m; ++i) {
			for (int j = 0; j <= n; ++j) {
				if (i == 0) {
					dis[i][j] = j;
				} else if (j == 0) {
					dis[i][j] = i;
				} else {
					dis[i][j] = Math.min(dis[i - 1][j] + 1, Math.min(dis[i][j - 1] + 1,
							dis[i - 1][j - 1] + (a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1)));
				}
			}
		}
		return dis[m][n];
	}

	// this approach was just made to maximise space efficiency
	public static int modifiedLevenshtein(String a, String b) {
		if (a == null)
			throw new IllegalArgumentException("String (a) cannot be null");
		if (b == null)
			throw new IllegalArgumentException("String (b) cannot be null");

		int n = a.length();
		int m = b.length();

		if (n == 0) {
			return m;
		}
		if (m == 0) {
			return n;
		}

		if (n > m) {
			final String tmp = a;
			a = b;
			b = tmp;
			n = m;
			m = b.length();
		}

		int[] p = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			p[i] = i;
		}

		for (int j = 1; j <= m; ++j) {
			int upperLeft = p[0];
			char jth = b.charAt(j - 1);
			p[0] = j;

			for (int i = 1; i <= n; ++i) {
				int upper = p[i];
				int cost = a.charAt(i - 1) == jth ? 0 : 1;
				p[i] = Math.min(Math.min(p[i - 1] + 1, p[i] + 1), upperLeft + cost);
				upperLeft = upper;
			}
		}
		return p[n];
	}
}
