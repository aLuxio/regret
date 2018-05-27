package State.st2018;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Richa {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/State/st2018/data/judgesData/richa.dat"));
		double[] points = { 4.5, 3.5, 2.5, 1, 0 };
		int[] credits = { 1, 2, 4 };
		HashMap<Integer, String> courses = new HashMap<>();
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T)
			courses.put(file.nextInt(), file.nextLine().trim());
		while(file.hasNext()) {
			String[] line = file.nextLine().split("\\s");
			double grade1 = points["ABCDF".indexOf(line[0].charAt(0))],
					grade2 = points["ABCDF".indexOf(line[2].charAt(0))];
			if(line[0].length() > 1)
				grade1 += Double.parseDouble(line[0].charAt(1) + ".25")
						+ (courses.get(Integer.parseInt(line[1])).charAt(0) == 'Y' && line[0].charAt(0) <= 'C' ? 0.5
								: 0);
			if(line[2].length() > 1)
				grade2 += Double.parseDouble(line[2].charAt(1) + ".25")
						+ (courses.get(Integer.parseInt(line[3])).charAt(0) == 'Y' && line[2].charAt(0) <= 'C' ? 0.5
								: 0);
			System.out.printf("%.3f%n",
					(grade1 * credits["QSY".indexOf(courses.get(Integer.parseInt(line[1])).charAt(1))]
					+ grade2 * credits["QSY".indexOf(courses.get(Integer.parseInt(line[3])).charAt(1))])
					/ (credits["QSY".indexOf(courses.get(Integer.parseInt(line[1])).charAt(1))]
							+ credits["QSY".indexOf(courses.get(Integer.parseInt(line[3])).charAt(1))]));
		}
		file.close();
	}
}
