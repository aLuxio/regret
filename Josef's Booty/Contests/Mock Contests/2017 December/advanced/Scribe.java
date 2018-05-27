package mockContests.december2017.advanced;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Scribe {
	public static void main(String[] args) throws IOException {
		String[] saguaro = { "    | |\n    | |\n    | |\n    | |\n    | |\n    | |",
				"    | |  _\n    | | / \\\n    | | | |\n    | |_/ /\n    |  __/\n    | /",
				" _  | |\n/ \\ | |\n| | | |\n\\ \\_| |\n \\__  |\n    \\ |",
				" _  | |  _\n/ \\ | | / \\\n| | | | | |\n\\ \\_| |_/ /\n \\__   __/\n    \\ /" };
		Scanner file = new Scanner(new File("src/mockContests/december2017/advanced/data/sampledata/scribe.dat"));
		while(file.hasNext()) {
			String line = file.nextLine();
			System.out.println("     _\n    / \\");
			if(!line.isEmpty())
				for(String s : line.split("\\s"))
					System.out.println(saguaro[Integer.parseInt(s, 2)]);
			System.out.println("    | |\n    | |\n");
		}
		file.close();
	}
}
