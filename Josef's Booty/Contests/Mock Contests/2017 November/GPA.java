package mockContests.november2017;

import java.util.*;
import java.io.*;
public class GPA {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/november2017/Data/judgesData/gpa.dat"));
		int T = file.nextInt();
		file.nextLine();
		for(; T > 0; --T) {
			ArrayList<Integer> homework = strToList(file.nextLine());
			ArrayList<Integer> tests = strToList(file.nextLine());
			Collections.sort(homework);
			Collections.sort(tests);
			long withoutTest = Math.round(average(tests.subList(1, tests.size())) * 0.5 + average(homework) * 0.5);
			long withoutHome = Math.round(average(homework.subList(1, homework.size())) * 0.5 + average(tests) * 0.5);
			System.out.println(Math.max(withoutTest, withoutHome));
		}
		file.close();
	}
	public static ArrayList<Integer> strToList(String nums) {
		ArrayList<Integer> temp = new ArrayList<>();
		Scanner chop = new Scanner(nums);
		while(chop.hasNextInt())
			temp.add(chop.nextInt());
		return temp;
	}
	public static int average(List<Integer> nums) {
		int avg = 0;
		for(int n : nums)
			avg += n;
		return avg / nums.size();
	}
}
