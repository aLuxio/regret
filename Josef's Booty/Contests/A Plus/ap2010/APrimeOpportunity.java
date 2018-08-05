package APlus.ap2010;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class APrimeOpportunity {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("prime.dat"));
		for(int T = file.nextInt(); T > 0; --T) {
			int num = file.nextInt();
			for(int i = 2; i <= num; ++i)
				while(num % i == 0) {
					System.out.print(i + (num <= i ? "" : " "));
					num /= i;
				}
			System.out.println();
		}
	}
}
