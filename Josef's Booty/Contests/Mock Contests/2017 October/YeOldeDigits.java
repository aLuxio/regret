package mockContests.october2017;

import java.util.*;
import java.io.*;
public class YeOldeDigits {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/october2017/data/sampledata/oldedigits.dat"));
		for(int T = file.nextInt(); T > 0; --T) {
			int x = file.nextInt();
			System.out.println(x % 2 == 0 ? x : x * 2);
		}
	}
}
