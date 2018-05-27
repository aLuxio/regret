package mockContests.october2017;

import java.util.*;
import java.io.*;
public class HistoNum {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/october2017/data/sampledata/histonum.dat"));
		int[] freq = new int[10];
		while(file.hasNext()) {
			int t = file.nextInt();
			while(t > 0) {
				freq[t % 10]++;
				t /= 10;
			}
		}
		for(int i = 0; i < 10; ++i) {
			if(freq[i] != 0) {
				System.out.print(i + "|");
				for(int n = 0; n < freq[i]; n++)
					System.out.print("*");
				System.out.println();
			}
		}
	}
}
