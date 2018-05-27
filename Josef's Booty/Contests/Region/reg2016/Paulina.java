package Region.reg2016.A;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Paulina {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/Region/reg2016/data/judgedata/paulina.dat"));
		while(file.hasNext()) {
			double x = 0, y = 0;
			for(int i = file.nextInt(); i > 0; --i) {
				int dist = file.nextInt(), angle = file.nextInt();
				x += Math.cos(Math.toRadians(angle)) * dist;
				y += Math.sin(Math.toRadians(angle)) * dist;
			}
			System.out.printf("(%.4f, %.4f)%n", x, y);
		}
		file.close();
	}
}
