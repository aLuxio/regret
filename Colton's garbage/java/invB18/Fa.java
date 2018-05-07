package invB18;

import static java.lang.System.*;
import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Fa
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data/invB2018/StudentData/fa.dat"));
		
		while(file.hasNext())
		{
			file.nextInt(); file.nextLine();
			int[] data = Arrays.stream(file.nextLine().split("\\s"))
					.mapToInt(Integer::parseInt)
					.toArray();
			
			int pivot = pivot(data);
			int[] sums = sums(data, pivot);
			
			out.printf("%d ^%d %d%n", sums[0], pivot, sums[1]);
		}
	}
	
	public static int pivot(int[] in)
	{
		int mid = in.length / 2;
		int i = mid;
		int[] sum = sums(in, i);
		
		while(i>=0 && i<in.length && sum[0] != sum[1])
		{
			if(sum[0] < sum[1])
				sum = sums(in, ++i);
			else
				sum = sums(in, --i);
		}
		
		return i;
	}
	
	public static int[] sums(int[] in, int pivot)
	{
		int[] sums = new int[2];
		
		for(int a=0; a<pivot; a++)
			sums[0] += in[a];
		for(int b=0; b<in.length; b++)
			sums[1] += in[b];
		
		return sums;
	}
}
