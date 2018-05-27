package mockContests.november2017;

import java.util.*;
import java.io.*;
public class Microwave {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/november2017/data/judgesdata/microwave.dat"));
		int T = file.nextInt();
		file.nextLine();
		for(; T > 0; --T) {
			int time = file.nextInt(), seconds;
			if(time > 99)
				seconds = time / 100 * 60 + time % 100;
			else
				seconds = time;
			System.out.format("%d seconds = %02d:%02d minutes.%n", seconds, seconds / 60, seconds % 60);
		}
		file.close();
	}
}
