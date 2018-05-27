package mockContests.january2018.advanced;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Metamorphism {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/january2018/data/judgesdata/metamorph.dat"));
		// while(file.hasNext())
		// System.out.println(file.nextLine().split(" ").length);
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			int dictSize = Integer.parseInt(file.nextLine());
			HashSet<String> dict = Arrays.stream(file.nextLine().split("\\s"))
					.collect(Collectors.toCollection(HashSet::new));
			String[] input = file.nextLine().split("\\s");
			System.out.println(wordLadder(input[0], input[1], dict));
		}
		file.close();
	}

	public static int wordLadder(String start, String end, Set<String> dictionary) {
		int pathLength = 2;
		Set<String> front = new HashSet<>(), back = new HashSet<>(), swap;
		front.add(start);
		back.add(end);
		dictionary.remove(start);
		dictionary.remove(end);
		while(!front.isEmpty()) {
			if(front.size() > back.size()) {
				swap = front;
				front = back;
				back = swap;
			}
			swap = new HashSet<>();
			for(String cur : front) {
				char[] word = cur.toCharArray();
				for(int i = 0; i < word.length; ++i) {
					char old = word[i];
					for(char c = 'a'; c <= 'z'; ++c) {
						word[i] = c;
						String nextWord = String.valueOf(word);
						if(back.contains(nextWord))
							return pathLength;
						if(dictionary.contains(nextWord)) {
							swap.add(nextWord);
							dictionary.remove(nextWord);
						}
					}
					word[i] = old;
				}
			}
			front = swap;
			pathLength++;
		}
		return -1;
	}
}
