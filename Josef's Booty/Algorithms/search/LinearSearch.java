package algorithms.search;

/* Searching for 100k integers within an array of 100k:
 * 	- Interpolation Search:   12.8052ms
 *	- Exponential Search  :   13.7367ms
 *	- Fibonacci Search    :   13.7406ms
 *	- Binary Search       :   17.5785ms
 *	- Jump Search         :   55.7152ms
 *	- Linear Search       : 1967.8909ms
 */

public class LinearSearch {
	public static void main(String[] args) {
		int arr[] = {2, 3, 4, 10, 40};
		System.out.println(linearSearch(arr, 10));
	}

	public static int linearSearch(int[] arr, int x) {
		if(arr == null) {
			throw new IllegalArgumentException("Array must not be null");
		}
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == x) {
				return i;
			}
		}
		return -1;
	}
}
