package mockContests.october2017;

import java.util.*;
import java.io.*;
public class Between {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/october2017/data/sampledata/between.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			String str = file.nextLine();
			while(str.length() >= 2) {
				System.out.println(str);
				str = str.substring(1, str.length() - 1);
			}
			System.out.println();
		}
		file.close();
	}
}
