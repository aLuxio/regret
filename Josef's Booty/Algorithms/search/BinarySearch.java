package algorithms.search;

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
