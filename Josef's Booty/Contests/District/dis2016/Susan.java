package District.dis2016;

import java.util.*;
import java.io.*;
public class Susan {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src\\District\\dis2016\\data\\susan.dat"));
		while(file.hasNext()) {
			String sentence = file.nextLine().trim();
			String[] regex = sentence.split(" (?=\\[)")[1].split("(?<=\\])(?=\\d+)");
			sentence = sentence.substring(0, sentence.indexOf("["));
			System.out.println(sentence.split(regex[0])[Integer.parseInt(regex[1])]);
		}
	}
}
