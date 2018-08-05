package District.dis2015;

import java.util.*;
import java.io.*;
public class Permutations {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src\\District\\dis2015\\data\\JudgeData\\permutations.dat"));
		int T = file.nextInt();
		file.nextLine();
		for(; T > 0; --T) {
			String s = file.nextLine();
			long[] fac = new long[s.length() + 1];
			for(int i = 0; i < fac.length; ++i) {
				fac[i] = i < 3 ? i : fac[i-1] * i;
			}
			int[] let = new int[26];
			for(char c : s.toCharArray()) {
				let[c - 'a']++;
			}
			long prod = 1;
			for(int i = 0; i < 26; ++i) {
				if(let[i] > 1) {
					prod *= fac[let[i]];
				}
			}
			System.out.println(fac[s.length()] / prod);
		}
	}
}
