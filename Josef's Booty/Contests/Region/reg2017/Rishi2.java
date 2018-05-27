package Region.reg2017.A;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Rishi {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/Region/reg2017/data/studentdata/rishi.dat"));
		while(file.hasNext()) {
			String s = file.nextLine();
			if(s.matches("[A-Z]+"))
				System.out.println(Arrays.stream(s.split("(?<=(.))(?!\\1)")).map(x -> x.length() + "" + x.charAt(0))
						.collect(Collectors.joining()));
			else
				System.out.println(Arrays.stream(s.split("(?<=[A-Z])(?=[0-9]+)")).map(x -> String.join("", Collections
						.nCopies(Integer.parseInt(x.substring(0, x.length() - 1)), "" + x.charAt(x.length() - 1))))
						.collect(Collectors.joining()));
		}
		file.close();
	}
}
