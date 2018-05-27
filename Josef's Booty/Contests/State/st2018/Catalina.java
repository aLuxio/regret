package State.st2018;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Catalina {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("Src/State/st2018/data/judgesdata/catalina.dat"));
		while(file.hasNext()) {
			System.out.println(file.nextLine().replaceAll("[^A-Z]", ""));
		}
		file.close();
	}
}
