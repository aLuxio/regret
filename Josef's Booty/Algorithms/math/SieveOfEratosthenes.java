package algorithms.math;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class SieveOfEratosthenes {
	public static void main(String[] args) {
		System.out.println(sieve(17));
		System.out.println(sieve(8));
		System.out.println(sieve(32));
		System.out.println(sieve(932));
	}

	public static LinkedList<Integer> sieve(int n) {
		BitSet set = new BitSet(n + 1);
		set.set(2, n + 1);
		for(int i = 2; i * i <= n; i = i > 2 ? i += 2 : i + 1) {
			for(int m = 2; m * i <= n; ++m) {
				set.clear(m * i);
			}
		}
		return set.stream().boxed().collect(Collectors.toCollection(LinkedList::new));
	}
}
