package mockContests.october2017;

import java.util.*;
import java.io.*;
public class SuperEffective {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/october2017/data/sampledata/super.dat"));
		for(int T = file.nextInt(); T > 0; --T) {
			int A = file.nextInt(), B = file.nextInt(), C = file.nextInt(), D = file.nextInt(), E = file.nextInt(), F = file.nextInt();
			int damage = ((((((A * 2 / 5) + 2) * B * C / 50) / E) + 2) * D / 100);
			System.out.println(damage >= F ? "Wow!! That was SUPER EFFECTIVE!!!" : "...");
		}
	}
}
