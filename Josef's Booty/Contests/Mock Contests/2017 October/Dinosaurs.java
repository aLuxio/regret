package mockContests.october2017;

import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Dinosaurs {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/october2017/data/judgesdata/dinosaurs.dat"));
		for(int T = file.nextInt(); T > 0; --T) {
			BigInteger dinos = file.nextBigInteger(), hugs = file.nextBigInteger();
			if(hugs.compareTo(dinos) >= 0)
				System.out.println(0);
			else
				System.out.println(dinos.subtract(hugs));
		}
	}
}
