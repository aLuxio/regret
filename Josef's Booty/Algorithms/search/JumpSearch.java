package algorithms.search;

/*	Jump Search is essentially just a linear search
 * 	that moves by more than one element at a time before
 * 	falling back on a normal linear search.
 * 
 * 	Searching for 2^31-1 integers within an array of 2^31-1:
 * 		- Linear Search	     : 5665.5221ms
 * 		- Binary Search	     : 525.6086ms
 * 		- Jump Search	     : 377.8101ms
 * 		- Exponential Search : 300.1572ms
 *
 * 	O(block size) in this case O(sqrt(n))
 */

public class JumpSearch {
	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 10, 40 };
		System.out.println(jumpSearch(arr, 10));
	}

	public static int jumpSearch(int[] arr, int X) {
		int arraySize = arr.length;
		int blockSize = (int) Math.floor(Math.sqrt(arraySize));
		int prev = 0;
		while(arr[Math.min(blockSize, arraySize) - 1] < X) {
			prev = blockSize;
			blockSize += (int) Math.floor(Math.sqrt(arraySize));
			if(prev >= arraySize)
				return -(arraySize + 1);
		}
		while(arr[prev] < X) {
			prev++;
			if(prev == Math.min(blockSize, arraySize))
				return -1;
		}
		if(arr[prev] == X)
			return prev;
		return -(prev + 1);
	}
}