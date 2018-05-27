package mockContests.november2017;

import java.util.*;
import java.io.*;
public class Words {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/november2017/data/judgesdata/words.dat"));
		int T = file.nextInt();
		file.nextLine();
		ArrayList<String> words = new ArrayList<>();
		for(; T > 0; --T) {
			Scanner chop = new Scanner(file.nextLine());
			while(chop.hasNext())
				words.add(chop.next());
		}
		Collections.sort(words);
		int queries = file.nextInt();
		file.nextLine();
		for(int q = 0; q < queries; q++) {
			int length = file.nextInt();
			String endsWith = file.nextLine().trim();
			boolean any = false;
			for(String word : words)
				if(word.length() == length && word.endsWith(endsWith)) {
					System.out.println(word);
					any = true;
				}
			if(!any)
				System.out.println("NONE");
			System.out.println();
		}
		file.close();
	}
}
