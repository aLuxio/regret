package mockContests.october2017;

import java.util.*;
import java.io.*;
public class SumDigits {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/october2017/data/sampledata/digits.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T)
			System.out.println(file.nextLine().chars().map(x -> x - '0').sum());
		file.close();
	}
}
