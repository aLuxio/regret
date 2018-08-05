package APlus.ap2012febA;

import java.io.*;
import java.util.*;

public class QuantumFun {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("quantum.dat"));
		for(int T = file.nextInt(); T > 0; --T) {
			int r = file.nextInt(), e = file.nextInt();
			System.out.println(r + "s" + (e > 1 ? 2 : 1) + (e > 2 ? "p" + (e - 2) : ""));
		}
	}
}
