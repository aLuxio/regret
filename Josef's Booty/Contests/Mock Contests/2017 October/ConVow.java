package mockContests.october2017;

import java.util.*;
import java.io.*;
public class ConVow {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/october2017/data/sampledata/convow.dat"));
		final String vowels = "aeiou";
		while(file.hasNext()) {
			final StringBuilder str = new StringBuilder(file.nextLine());
			for(int i = 0, vPos = 0; i < str.length(); ++i)
				if(Character.toString(str.charAt(i)).matches("[^ aeiou]"))
					str.setCharAt(i, vowels.charAt(vPos++ % 5));
			System.out.println(str.toString());
		}
		file.close();
	}
}
