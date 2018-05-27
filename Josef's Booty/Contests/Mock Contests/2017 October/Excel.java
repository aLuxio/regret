package mockContests.october2017;

import java.util.*;
import java.io.*;
public class Excel {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/october2017/data/judgesdata/excel.dat"));
		for(int T = file.nextInt(); T > 0; --T) {
			int number = file.nextInt();
			final StringBuilder result = new StringBuilder();
			while(number-- > 0) {
				result.append((char) ('A' + number % 26));
				number /= 26;
			}
			System.out.println(result.reverse().toString());
		}
		file.close();
	}
}
