package mockContests.january2018.advanced;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class MakeCommonNames {
	public static void main(String[] args) throws IOException {
		String[] names = new String[4945];
		Scanner file = new Scanner(new File("src/mockContests/january2018/data/names.txt"));
		for(int i = 0; i < names.length; ++i)
			names[i] = file.nextLine();
		Random randy = new Random();
		int datasets = randy.nextInt(20);
		System.out.println(datasets);
		for(int d = 0; d < datasets; ++d) {
			int distinct = 1 + randy.nextInt(85);
			Set<String> used = new HashSet<>();
			List<String> set = new ArrayList<>();
			while(used.size() != distinct) {
				String name = names[randy.nextInt(names.length)];
				while(!used.add(name))
					name = names[randy.nextInt(names.length)];
				int duplicates = randy.nextInt(used.size() + 1);
				for(int n = 0; n < duplicates; ++n) {
					set.add(name);
				}
			}
			Collections.shuffle(set);
			System.out.println(justify(randy, set));
		}
		file.close();
	}

	public static String justify(Random randy, List<String> names) {
		List<String> lines = new ArrayList<>();
		int maxLineLength = 1000, lineCount = 0;
		for(int index = 0; index < names.size();) {
			int tryToFit = randy.nextInt(25);
			if(index + tryToFit >= names.size())
				tryToFit = names.size() - index;
			List<String> sublist = names.subList(index, index + tryToFit);
			while(String.join(" ", sublist).length() > maxLineLength) {
				sublist.remove(sublist.size() - 1);
			}
			if(sublist.isEmpty())
				continue;
			index += sublist.size();
			lines.add(String.join(" ", sublist));
			lineCount++;
		}
		return lineCount + "\n" + String.join("\n", lines);
	}
}
