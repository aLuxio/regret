package Region.reg2018;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Bingwen {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/Region/reg2018/data/judgedata/bingwen.dat"));
		while(file.hasNext())
			System.out.format("%.2f%n", Math.cbrt(file.nextInt()));
		file.close();
	}
}
