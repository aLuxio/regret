import java.util.*;

public class FirstNPrimeNumbers {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(firstNPrimes(0)));
		System.out.println(Arrays.toString(firstNPrimes(1)));
		System.out.println(Arrays.toString(firstNPrimes(2)));
		System.out.println(Arrays.toString(firstNPrimes(3)));
		System.out.println(Arrays.toString(firstNPrimes(12)));
	}

	public static int[] firstNPrimes(int n) {
		int[] primes = new int[n];
		if(n > 0)
			primes[0] = 2;
		if(n > 1)
			primes[1] = 3;
		for(int i = 1, idx = 2; idx < n; ++i) {
			primes[idx++] = 6 * i - 1;
			if(idx < n)
				primes[idx++] = 6 * i + 1;
		}
		return primes;
	}
}
