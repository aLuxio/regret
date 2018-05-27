package mockContests.october2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class GenerateOutFiles {
	static PrintWriter printer;
	static Scanner file;

	public static void main(String[] args) throws FileNotFoundException {
		// conVow();
		// between();
		// excel();
		// backwards();
		// cheater();
		// yeOldeDigits();
	}

	static class Node {
		Set<Node> adj = new HashSet<>();
		char value;

		public Node(char val) {
			this.value = val;
		}
	}

	public static void automaton() throws FileNotFoundException {
		final Scanner file = new Scanner(new File("F:\\Mock Contest October 2k17\\Sample\\automaton.dat"));
		while(file.hasNext()) {
			final String[] line = file.nextLine().split("\\s");
			final String pattern = line[0], test = line[1];
			final String[] individualPatterns = pattern.split("U");
		}
		file.close();
	}

	public static void backwards() throws FileNotFoundException {
		printer = new PrintWriter(new File("E:\\Mock Contest October 2k17\\JudgesData\\back.out"));
		file = new Scanner(new File("E:\\Mock Contest October 2k17\\JudgesData\\back.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			final String line = file.nextLine();
			printer.write((line.equals(new StringBuilder(line).reverse().toString()) ? "SAME" : "NOT SAME") + "\n");
		}
		file.close();
		printer.close();
	}

	public static void cheater() throws FileNotFoundException {
		printer = new PrintWriter(new File("E:\\Mock Contest October 2k17\\JudgesData\\cheater.out"));
		file = new Scanner(new File("E:\\Mock Contest October 2k17\\JudgesData\\cheater.dat"));
		final int[] freq = new int[4];
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T)
			freq[file.nextLine().hashCode() % 4]++;
		Stream.of("YELLOW", "BLUE", "RED", "BLACK").sorted(Comparator.comparing(str -> -(freq[str.hashCode() % 4])))
				.map(str -> str + "\n").forEachOrdered(printer::write);
		file.close();
		printer.close();
	}

	public static void yeOldeDigits() throws FileNotFoundException {
		printer = new PrintWriter(new File("E:\\Mock Contest October 2k17\\JudgesData\\oldeDigits.out"));
		file = new Scanner(new File("E:\\Mock Contest October 2k17\\JudgesData\\oldeDigits.dat"));
		for(int T = file.nextInt(); T > 0; --T) {
			final int num = file.nextInt();
			printer.write(Integer.toString((num & 1) == 1 ? num * 2 : num));
			printer.write("\n");
		}
		file.close();
		printer.close();
	}

	public static void excel() throws FileNotFoundException {
		printer = new PrintWriter(new File("F:\\Mock Contest October 2k17\\JudgesData\\excel.out"));
		file = new Scanner(new File("F:\\Mock Contest October 2k17\\JudgesData\\excel.dat"));
		for(int T = file.nextInt(); T > 0; --T) {
			int number = file.nextInt();
			final StringBuilder result = new StringBuilder();
			while(number-- > 0) {
				result.append((char) ('A' + number % 26));
				number /= 26;
			}
			printer.write(result.reverse().toString() + "\n");
		}
		file.close();
		printer.close();
	}

	public static void sumDigits() throws FileNotFoundException {
		printer = new PrintWriter(new File("F:\\Mock Contest October 2k17\\JudgesData\\digits.out"));
		file = new Scanner(new File("F:\\Mock Contest October 2k17\\JudgesData\\digits.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T)
			printer.write(file.nextLine().chars().map(x -> x - '0').sum() + "\n");
		file.close();
		printer.close();
	}

	public static void superEffective() throws FileNotFoundException {
		printer = new PrintWriter(new File("F:\\Mock Contest October 2k17\\JudgesData\\super.out"));
		file = new Scanner(new File("F:\\Mock Contest October 2k17\\JudgesData\\super.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			final int A = file.nextInt(), B = file.nextInt(), C = file.nextInt(), D = file.nextInt(),
					E = file.nextInt(), F = file.nextInt();
			final int damage = ((((((A * 2 / 5) + 2) * B * C / 50) / E) + 2) * D / 100);
			printer.write((damage >= F ? "Wow!! That was SUPER EFFECTIVE!!!" : "...") + "\n");
		}
		file.close();
		printer.close();
	}

	public static void between() throws FileNotFoundException {
		printer = new PrintWriter(new File("F:\\Mock Contest October 2k17\\JudgesData\\between.out"));
		file = new Scanner(new File("F:\\Mock Contest October 2k17\\JudgesData\\between.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			String str = file.nextLine();
			while(str.length() >= 2) {
				printer.write(str + "\n");
				str = str.substring(1, str.length() - 1);
			}
			printer.write("\n");
		}
		file.close();
		printer.close();
	}

	public static void conVow() throws FileNotFoundException {
		printer = new PrintWriter(new File("F:\\Mock Contest\\October\\2k17\\JudgesData\\convow.out"));
		file = new Scanner(new File("F:\\Mock Contest October 2k17\\Sample\\convow.dat"));
		final String vowels = "aeiou";
		while(file.hasNext()) {
			final StringBuilder str = new StringBuilder(file.nextLine());
			for(int i = 0, vPos = 0; i < str.length(); ++i)
				if(Character.toString(str.charAt(i)).matches("[^ aeiou]"))
					str.setCharAt(i, vowels.charAt(vPos++ % 5));
			printer.write(str.toString() + "\n");
		}
		file.close();
		printer.close();
	}
}
