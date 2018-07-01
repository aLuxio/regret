package algorithms.search;

/* Searching for 100k integers within an array of 100k:
 *	- Exponential Search  :   15.0207ms
 * 	- Binary Search       :   19.5392ms	
 *	- Jump Search         :   52.1491ms
 *	- Linear Search       : 2055.8263ms
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
