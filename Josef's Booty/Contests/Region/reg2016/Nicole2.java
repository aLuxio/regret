package Region.reg2016.A;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Nicole {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/Region/reg2016/data/judgedata/nicole.dat"));
		while(file.hasNext()) {
			int a = file.nextInt(), b = file.nextInt(), c = file.nextInt(), n = file.nextInt() - 3;
			while(n-- > 0) {
				int temp = a + b + c - 3;
				a = b;
				b = c;
				c = temp;
			}
			System.out.println(c);
		}
		file.close();
	}
}
