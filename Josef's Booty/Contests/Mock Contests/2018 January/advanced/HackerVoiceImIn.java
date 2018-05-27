package mockContests.january2018.advanced;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HackerVoiceImIn {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/january2018/Data/judgesdata/hacker.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			int shift = Integer.parseInt(file.nextLine());
			String message = file.nextLine();
			for(char c : message.toCharArray()) {
				System.out
						.print(c == '&' ? ',' : c == ' ' ? ' ' : c == '%' ? '!' : c == '$' ? '.' : (char) (c - shift));
			}
			System.out.println();
		}
		file.close();
	}
}
