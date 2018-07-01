package algorithms.search;

/*	Exponential Search works by simply finding which
 * 	powers of two offer upper and lower bounds, between
 * 	which the element in question lies. Once this range
 * 	is found a simple binary search is used.
 *	
 * 	Searching for 100k integers within an array of 100k:
 * 		- Interpolation Search:   12.8052ms
 *		- Exponential Search  :   13.7367ms
 *		- Fibonacci Search    :   13.7406ms
 *		- Binary Search       :   17.5785ms
 *		- Jump Search         :   55.7152ms
 *		- Linear Search       : 1967.8909ms
 *
 * 	O(log index)
 */

import java.util.*;

public class ExponentialSearch {
	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 10, 40 };
		System.out.println(exponentialSearch(arr, 10));
	}

	public static int exponentialSearch(int[] arr, int X) {
		if(arr[0] == X)
			return 0;
		int i = 1;
		while(i < arr.length && arr[i] <= X)
			i = i * 2;
		return Arrays.binarySearch(arr, i / 2, Math.min(i, arr.length), X);
	}
}
