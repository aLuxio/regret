package algorithms.search;

/* Searching for 100k integers within an array of 100k:
 *	- Exponential Search  :   15.0207ms
 * 	- Binary Search       :   19.5392ms	
 *	- Jump Search         :   52.1491ms
 *	- Linear Search       : 2055.8263ms
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
