package algorithms.search;

/*	The Interpolation Search algorithm can find a number
 * 	quicker than a Binary Search; however, it relies on
 * 	a uniform distribution.
 * 
 *	Searching for 100k integers within an array of 100k:
 * 		- Interpolation Search:   12.8052ms
 *		- Exponential Search  :   13.7367ms
 *		- Fibonacci Search    :   13.7406ms
 *		- Binary Search       :   17.5785ms
 *		- Jump Search         :   55.7152ms
 *		- Linear Search       : 1967.8909ms
 * 
 * 	O(log log n) if uniformly distributed
 * 	O(n) otherwise
 */

public class InterpolationSearch {
	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 10, 40 };
		System.out.println(interpolationSearch(arr, 11));
	}

	public static int interpolationSearch(int[] arr, int X) {
		int lo = 0, hi = arr.length - 1;
		while(lo < hi && arr[lo] <= X && arr[hi] >= X) {
			int pos = (int) (lo + ((((double) hi - lo) / (arr[hi] - arr[lo])) * (X - arr[lo])));
			if(arr[pos] == X)
				return pos;
			if(arr[pos] < X)
				lo = pos + 1;
			else
				hi = pos - 1;
		}
		return ~lo;
	}
}
