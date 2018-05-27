package mockContests.november2017;

import java.util.*;
import java.io.*;
public class Cross {
	public static void main(String[] args) throws IOException {
		plebeian();
	}
	
	public static void plebeian() throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/november2017/data/judgesdata/cross.dat"));
		int T = file.nextInt();
		file.nextLine();
		for(; T > 0; --T) {
			String a = file.next(), dummy = file.next(), b = file.nextLine().trim();
			char[][] matrix = new char[b.length()][a.length()];
			int aMeetsB = -1, bMeetsA = -1;
			for(int i = 0; i < a.length(); ++i)
				if(b.indexOf(a.charAt(i)) != -1) {
					aMeetsB = i;
					bMeetsA = b.indexOf(a.charAt(i));
					break;
				}
			if(aMeetsB != -1) {
				for(int i = 0; i < a.length(); ++i)
					matrix[bMeetsA][i] = a.charAt(i);
				for(int i = 0; i < b.length(); ++i)
					matrix[i][aMeetsB] = b.charAt(i);
				for(int i = 0; i < matrix.length; ++i) {
					for(int j = 0; j < matrix[0].length; ++j)
						System.out.print(matrix[i][j] != 0 ? matrix[i][j] : " ");
					System.out.println();
				}
			} else {
				System.out.println("none");
			}
			System.out.println();
		}
		file.close();
	}
	public static void patrician() throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/november2017/data/judgesdata/cross.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			String[] words = file.nextLine().split("\\s");
			int commonA=-1, commonB=-1;
			for(commonA = 0; commonA < words[0].length(); ++commonA)
				if(words[2].indexOf(words[0].charAt(commonA)) > -1) {
					commonB = words[2].indexOf(words[0].charAt(commonA));
					break;
				}
			if(commonB == -1)
				System.out.println("none");
			else {
				char[][] box = new char[words[2].length()][words[0].length()];
				for(int i = 0; i < box.length; ++i)
					for(int j = 0; j < box[0].length; ++j)
						box[i][j] = i == commonB ? words[0].charAt(j) : j == commonA ? words[2].charAt(i) : ' ';
				for(char[] row : box)
					System.out.println(String.valueOf(row));
			}
			System.out.println();
		}
	}
}
