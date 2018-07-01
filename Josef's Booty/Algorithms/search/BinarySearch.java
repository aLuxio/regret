package algorithms.search;

/* Searching for 100k integers within an array of 100k:
 * 	Interpolation Search:   12.8052ms
 *	Exponential Search  :   13.7367ms
 *	Fibonacci Search    :   13.7406ms
 *	Binary Search       :   17.5785ms
 *	Jump Search         :   55.7152ms
 *	Linear Search       : 1967.8909ms
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
