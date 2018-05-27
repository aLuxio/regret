package mockContests.january2018.advanced;

import java.io.IOException;

public class BackwardsHacker {
	public static void main(String[] args) throws IOException {
		int shift = 10;
		String message = "man i smell it smell so good like good smell of good smelling food";
		for(char c : message.toCharArray()) {
			System.out.print(c == ',' ? '&' : c == ' ' ? ' ' : c == '!' ? '%' : c == '.' ? '$' : (char) (c + shift));
		}
	}
}
