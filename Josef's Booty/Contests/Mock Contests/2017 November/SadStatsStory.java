package mockContests.november2017;

import java.util.*;
import java.util.stream.IntStream;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
public class SadStatsStory {
	public static void main(String[] args) throws IOException {
		patrician();
	}
	public static void plebeian() throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/november2017/data/sampledata/stats.dat"));
		Stack<Integer> numbers = new Stack<>();	// store numbers
		double average = 0;
		while(file.hasNextInt()) {
			numbers.push(file.nextInt());		// add each new number to collection
			average += numbers.peek();			// add up for later average
		}
		int size = numbers.size();
		average /= size;						// woo averages
		double standardDeviation = 0;
		while(!numbers.isEmpty())				// for every number, square the difference between it and the average
			standardDeviation += Math.pow(average - numbers.pop(), 2);	// and add up
		standardDeviation = Math.sqrt(standardDeviation / size);		// square root it to go from standard variance to standard variation
		System.out.format("%.2f", standardDeviation);
		file.close();
	}
	public static void patrician() throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/november2017/data/sampledata/stats.dat"));
		int[] nums = Arrays.stream(file.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
		double avg = Arrays.stream(nums).average().getAsDouble();
		System.out.format("%.2f", Math.sqrt(IntStream.range(0, nums.length).mapToDouble(i -> avg - nums[i]).map(x -> x * x).sum() / nums.length));
	}
}
