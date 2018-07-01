package algorithms.search;

/*	Searching for 100k integers within an array of 100k:
 * 		- Interpolation Search:   12.8052ms
 *		- Exponential Search  :   13.7367ms
 *		- Fibonacci Search    :   13.7406ms
 *		- Binary Search       :   17.5785ms
 *		- Jump Search         :   55.7152ms
 *		- Linear Search       : 1967.8909ms
 */

public class FibonacciSearch {
	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 10, 40 };
		System.out.println(fibonacciSearch(arr, 11));
	}

	public static int fibonacciSearch(int[] arr, int X) {
		int fibA = 0, fibB = 1, fibC = 1, n = arr.length;
		while(fibC < n) {
			fibB = fibA;
			fibA = fibC;
			fibC = fibA + fibB;
		}
		int offset = -1;
		while(fibC > 1) {
			int pos = Math.min(offset + fibB, n - 1);
			if(arr[pos] == X)
				return pos;
			else if(arr[pos] < X) {
				fibC = fibA;
				fibA = fibB;
				fibB = fibC - fibA;
				offset = pos;
			} else {
				fibC = fibB;
				fibA = fibA - fibB;
				fibB = fibC - fibA;
			}
		}
		if(fibA == 1 && arr[offset + 1] == X)
			return offset + 1;
		return ~offset;
	}
}
