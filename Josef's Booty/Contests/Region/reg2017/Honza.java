package Region.reg2017.A;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Honza {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/Region/reg2017/data/studentdata/honza.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			String[] nums = file.nextLine().split("\\D+");
			if(Long.parseLong(nums[5]) > 1000000000000000000L)
				continue;
			LocalDateTime date = LocalDateTime
					.of(Integer.parseInt(nums[2]), Integer.parseInt(nums[0]), Integer.parseInt(nums[1]),
							Integer.parseInt(nums[3]), Integer.parseInt(nums[4]), 0)
					.plusMinutes(Long.parseLong(nums[5]) - 5);

			System.out.printf("%s %d/%d/%d %02d:%02d%n",
					date.getDayOfWeek().toString().charAt(0)
							+ date.getDayOfWeek().toString().toLowerCase().substring(1, 3),
					date.getDayOfMonth(),
					date.getMonthValue(), date.getYear(), date.getHour(), date.getMinute());
		}
		file.close();
	}
}
