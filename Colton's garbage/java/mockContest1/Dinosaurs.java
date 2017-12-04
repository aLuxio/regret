//Mock Contest 10-17-2017 - Problem 6 - Dinosaurs
//just fuck my shit up fam

package mockContest1;

import static java.lang.System.*;
import java.math.*;
import java.util.*;
import java.io.*;

public class Dinosaurs {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("data\\mc1017\\JudgesData\\dinosaurs.dat"));
		int count = file.nextInt();

		for (int a = 0; a < count; a++) {
			BigInteger num1 = file.nextBigInteger();
			BigInteger num2 = file.nextBigInteger();

			out.println(num1.subtract(num2).compareTo(new BigInteger("0")) >= 0 ? num1.subtract(num2) : 0);
		}

		file.close();
	}
}
