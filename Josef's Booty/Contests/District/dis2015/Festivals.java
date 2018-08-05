package District.dis2015;

import java.util.*;
import java.io.*;
public class Festivals {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src\\District\\dis2015\\data\\JudgeData\\festivals.dat"));
		int T = file.nextInt();
		file.nextLine();
		for(; T > 0; --T) {
			int year = file.nextInt();
			if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
				System.out.println(year + " is a leap year.");
				if(year % 18 == 0) {
					System.out.println(year + " is a Brimborion festival year.");
				}
			} else if(year % 25 == 0) {
				System.out.println(year + " is a Narishkeit festival year.");
			} else {
				System.out.println(year + " is an ordinary year.");
			}
			System.out.println();
		}
	}
}
