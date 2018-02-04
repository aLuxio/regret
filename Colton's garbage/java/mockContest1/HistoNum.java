//Mock Contest 10-17-2017 - Problem 7 - 

package mockContest1;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class HistoNum {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("data\\mc1017\\JudgesData\\histonum.dat"));
		Map<Character, String> hist = new TreeMap<>();

		while (file.hasNext()) {
			char[] digits = file.nextLine().toCharArray();
			for (char ind : digits) {
				if (!hist.containsKey(ind))
					hist.put(ind, "*");
				else {
					String temp = hist.get(ind);
					hist.put(ind, temp += "*");
				}
			}
		}

		for (char ind : hist.keySet())
			out.println(ind + "|" + hist.get(ind));

		file.close();
	}
}
