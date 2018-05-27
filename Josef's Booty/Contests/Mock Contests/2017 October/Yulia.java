package mockContests.october2017;

import java.util.*;
import java.io.*;
public class Yulia {
	public static void main(String[] args) throws IOException {
		final Scanner file = new Scanner(new File("src/mockContests/october2017/data/judgesData/yulia.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			int size = Integer.parseInt(file.nextLine());
			char[][] box = new char[size][];
			for(int i = 0; i < size; ++i)
				box[i] = file.nextLine().toLowerCase().toCharArray();
			String find = file.nextLine().toLowerCase();
			int max = 0;
			for(int i = 0; i < size; ++i) {
				String col = "";
				for(int j = 0; j < size; ++j)
					col += box[j][i];
				max = Math.max(max, Math.max(lcs(find, String.valueOf(box[i])), lcs(find, col)));
			}
			System.out.println(max);
		}
		file.close();
	}

	public static int lcs(String a, String b) {
		final int[][] lcs = new int[a.length() + 1][b.length() + 1];
		for(int i = 1; i <= a.length(); ++i)
			for(int j = 1; j <= b.length(); ++j)
				if(a.charAt(a.length() - i) == b.charAt(b.length() - j))
					lcs[i][j] = 1 + lcs[i - 1][j - 1];
				else
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
		return lcs[a.length()][b.length()];
	}
}
