package amConsolidated.amc2018;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DataMiner {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("miner.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			String in = file.nextLine();
			System.out.println(in.substring(in.indexOf("p:") + 2, in.lastIndexOf(":p")));
		}
		file.close();
	}
}
