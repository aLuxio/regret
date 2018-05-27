package algorithms.sorting;
import java.util.Random;

public class BogoSort
{
	public static void sort(int[] arr)
	{
		Random rand = new Random();
		while(!isSorted(arr))
		{
			for(int i = 0; i < arr.length; i++)
			{
				int a = rand.nextInt(arr.length);
				int b = rand.nextInt(arr.length);
				int t = arr[a];
				arr[a] = arr[b];
				arr[b] = t;
			}
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
		int[] arr = {3,6,3,2,8,6};
		sort(arr);
		System.out.println(java.util.Arrays.toString(arr));
	}
}
