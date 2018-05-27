package mockContests.november2017;

import java.util.*;
import java.io.*;

public class RomanNumeralTranslator {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/november2017/data/judgesdata/roman.dat"));
		while(file.hasNext()) {
			if(file.hasNextInt()) // if it is a number, make it a string
				System.out.println(String.join("", Collections.nCopies(Integer.parseInt(file.nextLine()), "I"))
						.replace("IIIII", "V")		// start out with just n I's
						.replace("IIII", "IV")		// turn every 5 I's into a V, and every 4 I's into a 'IV'
						.replace("VV", "X")			// continue until you're done
						.replace("VIV", "IX")
						.replace("XXXXX", "L")
						.replace("XXXX", "XL")
						.replace("LL", "C")
						.replace("LXL", "XC")
						.replace("CCCCC", "D")
						.replace("CCCC", "CD")
						.replace("DD", "M")
						.replace("DCD", "CD"));
			else {
				String rom = file.nextLine(); // otherwise make it a number
				int n = 0, rightDigit = 0;
				for(int i = rom.length() - 1; i >= 0; i--) {	// start at right to account for after larger = add
					
					// char will only be present in one of the strings. 10^-1 cast to an integer will become 0, leaving only the proper value
					int value = (int) (Math.pow(10, "IXCM".indexOf(rom.charAt(i))) + 5 * Math.pow(10, "VLD".indexOf(rom.charAt(i))));
					
					// if the right value is less than or equal to the left, val - right >> 31 | 1 returns 1, otherwise it returns -1
					n += value * (value - rightDigit >> 31 | 1);
					
					// reset right for the next digit
					rightDigit = value;
				}
				System.out.println(n);
			}
		}
		file.close();
	}
}
