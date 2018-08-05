package APlus.ap2010;

import java.io.*;
import java.util.*;

public class Objection {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("objection.dat"));
		for(int T = file.nextInt(); T > 0; --T) {
			int ob = file.nextInt();
			System.out.println(
					ob < 1 ? "Guilty\n" : String.join("\n", Collections.nCopies(ob, "Objection!")) + "\nHOLD IT!\n");
		}
	}
}
