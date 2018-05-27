package mockContests.november2017;

import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Nicole {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/november2017/data/judgesdata/nicole.dat"));
		while(file.hasNext()) {
			BigInteger a = file.nextBigInteger(), b = file.nextBigInteger(), c = file.nextBigInteger(), negThree = BigInteger.valueOf(-3), temp;
			for(int index = file.nextInt() - 1; index > 0; --index) {
				temp = a.add(b).add(c).add(negThree);
				a = b;
				b = c;
				c = temp;
			}
			System.out.println(a);
		}
		file.close();
	}
}
