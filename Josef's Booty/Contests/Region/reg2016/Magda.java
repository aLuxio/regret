package Region.reg2016.A;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Magda {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/Region/reg2016/data/judgedata/magda.dat"));
		while(file.hasNext()) {
			BigDecimal d = file.nextBigDecimal();
			StringBuilder ans = new StringBuilder(".");
			while(d.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) > 0 && ans.length() < 11) {
				d = d.multiply(BigDecimal.valueOf(2));
				if(d.compareTo(BigDecimal.ONE) >= 0) {
					ans.append('1');
					d = d.subtract(BigDecimal.ONE);
				} else
					ans.append('0');
			}
			System.out.println(ans.toString());
		}
		file.close();
	}
}
