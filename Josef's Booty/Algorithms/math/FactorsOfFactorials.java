import java.util.*;

public class FactorsOfFactorials {
	public static void main(String[] args) {
		System.out.println(countFactorsOfNFactorial(1));
		System.out.println(countFactorsOfNFactorial(2));
		System.out.println(countFactorsOfNFactorial(3));
		System.out.println(countFactorsOfNFactorial(15));
		System.out.println(countFactorsOfNFactorial(150));
	}

	public static long countFactorsOfNFactorial(int n) {
		LinkedList<Integer> primes = primesBelowN(n);
		long ans = 1;
		for(int prime : primes) {
			int temp = n / prime, count = 0;
			while(temp > 0) {
				count += temp;
				temp /= prime;
			}
			ans *= (count + 1);
		}
		return ans;
	}

	public static LinkedList<Integer> primesBelowN(int n) {
		LinkedList<Integer> primes = new LinkedList<>();
		if(n > 1)
			primes.add(2);
		if(n > 2)
			primes.add(3);
		for(int i = 1; 6 * i - 1 <= n; ++i) {
			primes.add(6 * i - 1);
			if(6 * i + 1 <= n)
				primes.add(6 * i + 1);
		}
		return primes;
	}
}
