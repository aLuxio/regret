package algorithms.search;

/* Searching for 2^31-1 integers within an array of 2^31-1:
 * 	- Linear Search      : 5665.5221ms
 * 	- Binary Search	     : 525.6086ms
 * 	- Jump Search	     : 377.8101ms
 * 	- Exponential Search : 300.1572ms
 */

public class BinarySearch {
	public static void main(String[] args) {
		int arr[] = {2, 3, 4, 10, 40};
		System.out.println(binarySearch(arr, 10));
	}

	public static int binarySearch(int[] arr, int x) {
		int lo = 0, hi = arr.length - 1, mid = 0;
		while(lo <= hi) {
			mid = lo + (hi - lo) / 2;
			if(arr[mid] == x) {
				return mid;
			}
			else if(arr[mid] < x) {
				lo = mid + 1;
			}
			else {
				hi = mid - 1;
			}
		}
		return ~mid;
	}
}
