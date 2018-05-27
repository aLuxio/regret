package mockContests.december2017.advanced;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Repetition {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/december2017/advanced/data/sampledata/repetition.dat"));
		while(file.hasNext()) {
			String str = file.next();
			int n = Integer.parseInt(file.nextLine().trim());
			for(int i = 0; i < n; ++i)
				System.out.println(str.substring(0, n));
		}
		file.close();
	}
}
