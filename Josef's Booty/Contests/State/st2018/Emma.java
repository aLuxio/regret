package State.st2018;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Emma {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/State/st2018/data/judgesData/emma.dat"));
		while(file.hasNext()) {
			int size = file.nextInt() * 3;
			for(int i = 0; i < size; ++i) {
				for(int j = 0; j < size; ++j)
					System.out.print((i < size / 3 || i >= size - size / 3) && (j < size / 3 || j >= size - size / 3)
							|| i == j || i == size - j - 1 ? "*" : " ");
				System.out.println();
			}
			System.out.println("==========");
		}
		file.close();
	}
}
