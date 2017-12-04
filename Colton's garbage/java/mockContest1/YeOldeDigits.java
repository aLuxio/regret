//Mock Contest 10-17-2017 - Problem 5 - Ye Olde Digits

package mockContest1;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class YeOldeDigits {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("data\\mc1017\\Sample\\yeoldedigits.dat"));
		int count = file.nextInt();

		for (int a = 0; a < count; a++) {
			int x = file.nextInt();
			out.println(x % 2 == 1 ? x * 2 : x);
		}

		file.close();
	}
}
