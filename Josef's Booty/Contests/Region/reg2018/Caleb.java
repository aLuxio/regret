package Region.reg2018;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Caleb {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/Region/reg2018/data/judgedata/caleb.dat")).useDelimiter("\\D+");
		for(int T = file.nextInt(); T > 0; --T) {
			int num = (int) (file.nextInt() / 360.0 * 12), den = (int) (file.nextInt() / 360.0 * 60);
			System.out.format("%d:%02d%n", num == 0 ? 12 : num, den);
		}
		file.close();
	}
}
