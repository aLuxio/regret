package Region.reg2015;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Toffee {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/Region/reg2015/data/judgedata/toffee.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			int size = Integer.parseInt(file.nextLine());
			int[][] box = new int[size][size];
			for(int i = 0; i < size; ++i)
				box[i] = Arrays.stream(file.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			for(int i = 1; i < size; ++i)
				for(int j = 0; j < size; ++j)
					box[i][j] += Math.max(box[i - 1][j], j == 0 ? 0 : box[i - 1][j - 1]);
			System.out.println(Arrays.stream(box[size - 1]).max().getAsInt());
		}
		file.close();
	}
}
