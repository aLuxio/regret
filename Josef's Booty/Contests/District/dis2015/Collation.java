package District.dis2015;

import java.util.*;
import java.io.*;
public class Collation {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src\\District\\dis2015\\data\\JudgeData\\collation.dat"));
		int T = file.nextInt();
		file.nextLine();
		for(; T > 0; --T) {
			String alpha = file.nextLine();
			int w = file.nextInt();
			file.nextLine();
			String[] words = Arrays.stream(file.nextLine().split(" ")).sorted((a, b) -> {
				if(a.startsWith(b))
					return 1;
				if(b.startsWith(a))
					return -1;
				int i = 0;
				while(i < Math.min(a.length(), b.length()) && a.charAt(i) == b.charAt(i)) {
					i++;
				}
				return alpha.indexOf(a.charAt(i)) - alpha.indexOf(b.charAt(i));
			}).toArray(String[]::new);
			System.out.println(Arrays.toString(words).replaceAll("[\\[\\],]", ""));
		}
	}
}
