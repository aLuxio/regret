package State.st2018;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Konstantinos {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/State/st2018/data/judgesData/konstantinos.dat"));
		while(file.hasNext()) {
			double x1 = file.nextInt(), y1 = file.nextInt(), r1 = file.nextInt(), x2 = file.nextInt(),
					y2 = file.nextInt(), r2 = file.nextInt();
			if(Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) == r1 + r2) {
				System.out.println("EXTERNALLY TANGENT");
			} else if(Math.abs(Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2))) == Math.abs(r1 - r2)) {
				System.out.println("INTERNALLY TANGENT");
			} else if(Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) < Math.abs(r1 - r2)) {
				System.out.println("NESTED");
			} else if(Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) > r1 + r2) {
				System.out.println("NON-INTERSECTING");
			} else
				System.out.println("INTERSECTING");
		}
		file.close();
	}
}
