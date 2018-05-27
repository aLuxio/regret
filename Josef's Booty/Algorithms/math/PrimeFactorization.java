package algorithms.math;

import java.util.LinkedList;

public class PrimeFactorization {
	public static void main(String[] args) {
		System.out.println(factors(17));
		System.out.println(factors(8));
		System.out.println(factors(32));
		System.out.println(factors(932));
	}

	public static LinkedList<Integer> factors(int n) {
		LinkedList<Integer> list = new LinkedList<>();
		for(int fac = 2; fac <= n; ++fac) {
			while(n % fac == 0) {
				list.add(fac);
				n /= fac;
			}
		}
		return list;
	}
}
