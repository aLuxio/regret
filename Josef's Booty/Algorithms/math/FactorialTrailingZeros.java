package algorithms.math;

public class FactorialTrailingZeros {
	public static void main(String[] args) {
		System.out.println(trailingZeros(5));
		System.out.println(trailingZeros(12));
		System.out.println(trailingZeros(18));
		System.out.println(trailingZeros(25));
		System.out.println(trailingZeros(13));
		System.out.println(trailingZeros(3));
		System.out.println(trailingZeros(7));
		System.out.println(trailingZeros(4));
		System.out.println(trailingZeros(50));
	}

	public static int trailingZeros(int n) {
		int c = 0;
		for(int i = 5; i <= n; i *= 5)
			c += n / i;
		return c;
	}
}
