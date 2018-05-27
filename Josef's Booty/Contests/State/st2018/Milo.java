package State.st2018;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Milo {
	public static void main(String[] args) throws IOException {
		Files.lines(Paths.get("src/State/st2018/data/judgesData/milo.dat")).map(Milo::toArabic)
				.forEachOrdered(System.out::println);
	}

	public static int toArabic(String roman) {
		int right = -1, value = 0;
		for(int i = roman.length() - 1; i >= 0; --i) {
			int v = (int) Math.pow(10, "IXCM".indexOf(roman.charAt(i)))
					+ 5 * (int) Math.pow(10, "VLD".indexOf(roman.charAt(i)));
			value += Math.signum(v - right + 0.5) * v;
			right = v;
		}
		return value;
	}
}
