package Region.reg2017.A;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class Camilo {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/region/reg2017/data/judgedata/camilo.dat"));
		while(file.hasNext()) {
			int n = file.nextInt();
			for(int i = 0; i <= n; ++i)
				System.out.println(String.join("", Collections.nCopies(i + 1, "*")));
			n--;
			for(int i = n - (n & 1); i >= 0; i -= 2)
				System.out.println(String.join("", Collections.nCopies(i + 1, "*")));
			System.out.println();
		}
		file.close();
	}
}
