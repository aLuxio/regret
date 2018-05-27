package algorithms.math;

public class EuclideanGCD {
	public static void main(String[] args) {
		System.out.println(gcd(15, 100));
		System.out.println(gcd(0, 1));
		System.out.println(gcd(1, 0));
		System.out.println(gcd(1024, 4096));
	}

	public static int gcd(int a, int b) {
		if(Math.min(a, b) == 0)
			return Math.max(a, b);
		return gcd(b, a % b);
	}
}
