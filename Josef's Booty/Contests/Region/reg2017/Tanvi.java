package Region.reg2017.A;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Tanvi {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/Region/reg2017/data/judgedata/tanvi.dat")).useDelimiter("\\D+");
		for(int T = file.nextInt(); T > 0; --T) {
			Point[] times = new Point[file.nextInt()];
			for(int i = 0; i < times.length; ++i)
				times[i] = new Point(file.nextInt() * 100 + file.nextInt(), file.nextInt() * 100 + file.nextInt());
			Arrays.sort(times, Comparator.comparing(time -> time.y));
			LinkedList<Point> selection = new LinkedList<>();
			selection.add(times[0]);
			for(int i = 0; i < times.length; ++i)
				if(times[i].x > selection.getLast().y)
					selection.add(times[i]);
			System.out.println(selection.stream()
					.map(p -> String.format("[%02d:%02d, %02d:%02d]", p.x / 100, p.x % 100, p.y / 100, p.y % 100))
					.collect(Collectors.joining(" ")));
		}
		file.close();
	}
}
