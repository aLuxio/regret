package APlus.ap2011oct;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class TalkALot {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("talk.dat"));
		for(int T = file.nextInt(); T > 0; --T) {
			HashMap<Character, Point> coords = new HashMap<>();
			char[][] box = new char[file.nextInt()][file.nextInt()];
			int q = file.nextInt();
			file.nextLine();
			for(int i = 0; i < box.length; ++i) {
				String line = file.nextLine();
				for(int j = 0; j < box[0].length; ++j) {
					box[i][j] = line.charAt(j);
					coords.put(line.charAt(j), new Point(i, j));
				}
			}
			boolean adj = false;
			for(; q > 0; q--) {
				char[] target = file.nextLine().toCharArray();
				if(Math.abs(coords.get(target[0]).x - coords.get(target[1]).x) <= 1
						&& Math.abs(coords.get(target[0]).y - coords.get(target[1]).y) <= 1 && (adj = true))
					System.out.println(String.valueOf(target));
			}
			System.out.println(adj ? "\n" : "OK\n");
		}
	}
}
