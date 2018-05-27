package State.st2018;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class Johnny {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/State/st2018/data/judgesData/johnny.dat"));
		Map<String, String> convert = new HashMap<>();
		while(file.hasNext("[^A-Z0-9]"))
			convert.put(file.next(), Arrays.stream(file.nextLine().trim().split("/")).map(x -> "\\b" + x + "\\b")
					.collect(Collectors.joining("|", "(", ")")));
		while(file.hasNext()) {
			String line = file.nextLine();
			for(Map.Entry<String, String> e : convert.entrySet())
				line = line.replaceAll(e.getValue(), Matcher.quoteReplacement(e.getKey()));
			System.out.println(line.replaceAll("\\s", ""));
		}
		file.close();
	}
}
