package algorithms.dynamicProgramming;

import java.util.*;
import java.util.stream.IntStream;
import java.io.*;
public class MaximumSumSubarray {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(kadane(new int[]{-2, -3, 4, 1, -2, -1, 5, -3})));
		System.out.println(Arrays.toString(kadane(new int[]{-2, -3, -4, -1, -2, -1, -5, -3})));
		System.out.println(Arrays.toString(kadane(new int[] {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1})));
	}
	public static int[] kadane(int[] arr) {
		int maxSoFar = arr[0], maxHere = arr[0], start = 0, end = 0, s = 0;
		for(int i = 1; i < arr.length; ++i) {
			maxHere += arr[i];
			if(maxHere < arr[i]) {
				maxHere = arr[i];
				s = i;
			}
			if(maxSoFar < maxHere) {
				maxSoFar = maxHere;
				start = s;
				end = i;
			}
		}
		return IntStream.rangeClosed(start, end).map(x -> arr[x]).toArray();
	}
}
