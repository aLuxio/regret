package State.st2017.A;

import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Dai {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/State/st2017/data/judgesdata/dai.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			int[] nums = Arrays.stream(file.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
			ArrayList<Line2D.Double> lines = new ArrayList<>(nums.length / 4);
			for(int i = 0; i < nums.length; i += 4)
				lines.add(new Line2D.Double(nums[i], nums[i + 1], nums[i + 2], nums[i + 3]));
			used = new LinkedList<>();
			intersectingSegments(lines);
			System.out.println(used.size());
		}
		file.close();
	}

	static LinkedList<Line2D.Double> used;

	public static boolean intersectingSegments(ArrayList<Line2D.Double> loins) {
		if(used.size() > 2 && used.getFirst().intersectsLine(used.getLast()))
			return true;
		for(int i = 0; i < loins.size(); ++i) {
			Line2D.Double loin = loins.get(i);
			if(used.isEmpty() || used.getLast().intersectsLine(loin)) {
				used.add(loin);
				loins.remove(loin);
				if(intersectingSegments(loins))
					return true;
				used.remove(loin);
				loins.add(i, loin);
			}
		}
		return false;
	}
}
