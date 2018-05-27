package mockContests.november2017;

import java.util.*;
import java.io.*;
public class Dry {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/november2017/data/judgesdata/dry.dat"));
		int T = file.nextInt();
		file.nextLine();
		for(; T > 0; --T) {
			String line = file.nextLine();
			String longestUnique = "";
			for(int start = 0; start < line.length(); ++ start) {
				for(int end = start + 1; end < line.length() + 1; ++end) {
					String possibleUnique = line.substring(start, end);
					boolean isUnique = true;
					for(int i = 0; i < possibleUnique.length(); ++i)
						if(possibleUnique.lastIndexOf(possibleUnique.charAt(i)) != i)
							isUnique = false;
					if(isUnique && possibleUnique.length() > longestUnique.length())
						longestUnique = possibleUnique;
				}
			}
			System.out.println(longestUnique);
		}
		file.close();
	}
}
