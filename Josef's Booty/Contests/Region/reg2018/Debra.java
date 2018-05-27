package Region.reg2018;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Debra {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/Region/reg2018/data/judgedata/debra.dat"));
		while(file.hasNext()) {
			int rows = file.nextInt(), cols = Integer.parseInt(file.nextLine().trim());
			for(; rows > 0; --rows)
				System.out.println(new StringBuilder(file.nextLine()).reverse().toString());
			System.out.println("=====");
		}
		file.close();
	}
}
