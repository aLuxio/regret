package Region.reg2016.A;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Scanner;

public class Quincy {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/Region/reg2016/data/studentdata/quincy.dat"));
		while(file.hasNext()) {
			BigDecimal a = file.nextBigDecimal(), b = a.divide(BigDecimal.valueOf(2)),
					c = a.multiply(BigDecimal.valueOf(2));
			int[] count = new int[30];
			a.toPlainString().chars().filter(x -> x != '.').forEach(x -> count[x - 48]++);
			b.toPlainString().chars().filter(x -> x != '.').forEach(x -> count[x - 38]++);
			c.toPlainString().chars().filter(x -> x != '.').forEach(x -> count[x - 28]++);
			System.out.println(a.toPlainString().substring(0, Math.min(a.toPlainString().length(), 60)) + "\n"
					+ b.toPlainString().substring(0, Math.min(b.toPlainString().length(), 60)) + "\n"
					+ c.toPlainString().substring(0, Math.min(c.toPlainString().length(), 60)));
			for(int i = 0; i < 10; ++i)
				System.out.printf("%d %s|%s|%s%n",
						i,
						count[i] > 25 ? (count[i] + "*s") : String.join("", Collections.nCopies(count[i], "*")),
						count[i + 10] > 25 ? (count[i + 10] + "*s")
								: String.join("", Collections.nCopies(count[i + 10], "*")),
						count[i + 20] > 25 ? (count[i + 20] + "*s")
								: String.join("", Collections.nCopies(count[i + 20], "*")));
			System.out.println();
		}
		file.close();
	}
}
