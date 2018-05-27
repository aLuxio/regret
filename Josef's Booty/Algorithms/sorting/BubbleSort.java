package algorithms.sorting;

public class BubbleSort
{
	public static void sort(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
			for(int j = i + 1; j < arr.length; j++)
				if(arr[j] < arr[i])
				{
					int t = arr[i];
					arr[i] = arr[j];
					arr[j] = t;
				}
	}
	public static void main(String[] args)
	{
		int[] arr = {3,6,3,2,8,6,423,234,1,1,3,4556};
		sort(arr);
		System.out.println(java.util.Arrays.toString(arr));
	}
}
