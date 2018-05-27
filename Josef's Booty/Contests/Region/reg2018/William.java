package Region.reg2018;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class William {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/region/reg2018/data/judgedata/william.dat"));

		while(file.hasNext()) {
			String s = file.nextLine();
			String a = s.substring(0, s.length() / 2);
			String b = new StringBuilder(s.substring(s.length() / 2)).reverse().toString();
			StringBuilder d = new StringBuilder(l(a, b));
			System.out.println(d + ":" + d.reverse());
		}
	}

	public static String l(String a, String b) {
		String[][] d = new String[a.length() + 1][b.length() + 1];
		for(String[] row : d)
			Arrays.fill(row, "");
		for(int i = 1; i < d.length; ++i)
			for(int j = 1; j < d[0].length; ++j)
				if(a.charAt(a.length() - i) == b.charAt(b.length() - j))
					d[i][j] = a.charAt(a.length() - i) + d[i - 1][j - 1];
				else {
					String z = d[i - 1][j], y = d[i][j - 1];
					d[i][j] = z.length() > y.length() ? z : y;
				}
		return d[a.length()][b.length()];
	}
}
