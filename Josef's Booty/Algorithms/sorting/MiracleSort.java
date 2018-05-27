package algorithms.sorting;

public class MiracleSort
{
	public static void sort(int[] arr) throws InterruptedException
	{
		while(!isSorted(arr))
		{
			Thread.sleep(5);
		}
	}
	private static boolean isSorted(int[] arr)
	{
		for(int i = 1; i < arr.length; i++)
			if(arr[i] < arr[i-1])
				return false;
		return true;
	}
	public static void main(String[] args) throws Throwable
	{
		int[] arr = {3,6,3,2,8,6,423,234,1,1,3,4556};
		sort(arr);
		System.out.println(java.util.Arrays.toString(arr));
	}
}
