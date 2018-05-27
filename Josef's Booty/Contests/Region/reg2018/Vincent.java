package Region.reg2018;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class Vincent {
	public static void main(String[] args) throws IOException {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MMMM d, yyyy - hh:mm - a");
		Scanner file = new Scanner(new File("src/Region/reg2018/data/judgedata/vincent.dat"));
		while(file.hasNext()) {
			LocalDateTime time = LocalDateTime.of(file.nextInt(), file.nextInt(), file.nextInt(), file.nextInt(),
					file.nextInt());
			file.nextLine();
			System.out.println(time.format(format) + "\n-----");
			Arrays.stream(file.nextLine().split("\\s")).mapToInt(Integer::parseInt).mapToObj(x -> time.plusMinutes(x))
					.map(format::format).forEachOrdered(System.out::println);
			System.out.println("=====");
		}
		file.close();
	}
}
