package District.dis2015;

import java.util.*;
import java.io.*;
public class Books {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src\\District\\dis2015\\data\\JudgeData\\books.dat"));
		int T = file.nextInt();
		for(; T > 0; --T) {
			double weight = file.nextDouble();
			int books = file.nextInt();
			double[] bookWeights = new double[books];
			for(int i = 0; i < books; ++i) {
				bookWeights[i] = file.nextDouble();
			}
			Arrays.sort(bookWeights);
			int count = 0;
			double sum = 0;
			for(double b : bookWeights) {
				sum += b;
				if(sum > weight) {
					break;
				}
				count++;
			}
			System.out.println(count);
		}
	}
}
