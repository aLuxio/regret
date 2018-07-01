package algorithms.math;

public class ExtendedGCD {
	public static void main(String[] args) {
		int[] coefficients;
		System.out.printf("%d = %d(%d) + %d(%d)%n", extendedGCD(15, 100, coefficients = new int[2]), 15,
				coefficients[0],
				100, coefficients[1]);
		System.out.printf("%d = %d(%d) + %d(%d)%n", extendedGCD(0, 1, coefficients = new int[2]), 0, coefficients[0], 1,
				coefficients[1]);
		System.out.printf("%d = %d(%d) + %d(%d)%n", extendedGCD(1, 0, coefficients = new int[2]), 1, coefficients[0], 0,
				coefficients[1]);
		System.out.printf("%d = %d(%d) + %d(%d)%n", extendedGCD(1024, 4096, coefficients = new int[2]), 1024,
				coefficients[0], 4096, coefficients[1]);
		System.out.printf("%d = %d(%d) + %d(%d)%n", extendedGCD(-10, 15, coefficients = new int[2]), -10,
				coefficients[0], 15, coefficients[1]);
	}

	public static int extendedGCD(int a, int b, int[] c) {
		if(a == 0) {
			c[0] = 0;
			c[1] = 1;
			return b;
		}
		int[] t = { 1, 1 };
		int gcd = extendedGCD(b % a, a, t);
		c[0] = t[1] - b / a * t[0];
		c[1] = t[0];
		return gcd;
	}
}
