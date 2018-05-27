package mockContests.october2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class GenerateDatFiles {
	static PrintWriter printer;

	public static void main(String[] args) throws FileNotFoundException {
		cheater();
	}

	public static void cheater() throws FileNotFoundException {
		printer = new PrintWriter(new File("E:\\Mock Contest October 2k17\\JudgesData\\cheater.dat"));
		final ArrayList<String> fillFile = new ArrayList<>();
		final int red = (int) (Math.random() * 1000), blue = (int) (Math.random() * 1000),
				black = (int) (Math.random() * 1000), yellow = (int) (Math.random() * 1000);
		System.out.println(red + " " + blue + " " + black + " " + yellow);
		fillFile.addAll(Collections.nCopies(red, "RED"));
		fillFile.addAll(Collections.nCopies(blue, "BLUE"));
		fillFile.addAll(Collections.nCopies(black, "BLACK"));
		fillFile.addAll(Collections.nCopies(yellow, "YELLOW"));
		Collections.shuffle(fillFile);
		printer.write(Integer.toString(fillFile.size()) + "\n");
		for (final String color : fillFile)
			printer.write(color + "\n");
		printer.close();
	}
}
