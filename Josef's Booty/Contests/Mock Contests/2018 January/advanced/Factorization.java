package mockContests.january2018.advanced;

import java.io.File;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Factorization {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/january2018/Data/judgesdata/factors.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			int n = file.nextInt(), k = file.nextInt(), fac = 2;
			PriorityQueue<Integer> primeFactorization = new PriorityQueue<>();
			while(fac <= n && n > 0) {
				if(n % fac == 0) {
					n /= fac;
					primeFactorization.add(fac);
				} else
					fac++;
			}
			while(primeFactorization.size() > k) {
				primeFactorization.add(primeFactorization.poll() * primeFactorization.poll());
			}
			while(!primeFactorization.isEmpty())
				System.out.print(primeFactorization.poll() + " ");
			System.out.println();
		}
		file.close();
	}
}
