package amConsolidated.amc2018;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class StarStudent {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("star.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			String name = "gi;";
			int score = 0;
			for(int p = Integer.parseInt(file.nextLine()); p > 0; --p) {
				String[] in = file.nextLine().split(" ");
				if(Integer.parseInt(in[1]) > score) {
					name = in[0];
					score = Integer.parseInt(in[1]);
				}
			}
			System.out.println(name);
		}
		file.close();
	}
}
