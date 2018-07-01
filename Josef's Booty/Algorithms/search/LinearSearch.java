package algorithms.search;

/* Searching for 2^31-1 integers within an array of 2^31-1:
 * 	- Linear Search	     : 5665.5221ms
 * 	- Binary Search	     : 525.6086ms
 * 	- Jump Search	     : 377.8101ms
 * 	- Exponential Search : 300.1572ms
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
