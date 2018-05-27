package mockContests.october2017;

import java.util.*;
import java.io.*;
public class Tutors {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/october2017/data/judgesdata/tutors.dat"));
		int T = file.nextInt();
		file.nextLine();
		for(; T > 0; --T) {
			int[] tutors = Arrays.stream(file.nextLine().split("\\s")).skip(1).mapToInt(Integer::parseInt).toArray();
			int[] tutees = Arrays.stream(file.nextLine().split("\\s")).skip(1).mapToInt(Integer::parseInt).toArray();
			int tuts = tutors.length;
			long possible = 0;
			for(int t : tutees) {
				int n = exponential(tutors, t);
				while(n >= 0 && n + 1 < tuts && tutors[n] == tutors[n + 1])
					n++;
				possible += n >= 0 ? tuts - n - 1 : tuts - ~n;
			}
			System.out.println(possible);
		}
	}
	// O(log index)
	public static int exponential(int[] arr, int X) {
		if(arr[0] == X)
			return 0;
		int i = 1;
		while(i < arr.length && arr[i] <= X)
			i = i * 2;
		return Arrays.binarySearch(arr, i / 2, Math.min(i, arr.length), X);
	}
}
