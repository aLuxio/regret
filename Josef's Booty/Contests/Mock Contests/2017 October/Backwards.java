package mockContests.october2017;

import java.util.*;
import java.io.*;
public class Backwards {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/october2017/data/sampledata/back.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			String line = file.nextLine();
			System.out.println(line.equals(new StringBuilder(line).reverse().toString()) ? "SAME" : "NOT SAME");
		}
	}
}
