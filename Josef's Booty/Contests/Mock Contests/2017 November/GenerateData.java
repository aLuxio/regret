package mockContests.november2017;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


import java.io.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
public class GenerateData {
	public static void main(String[] args) throws IOException {
		gpaOut();
	}

	public static void shiftingGearsIn() throws IOException {
		PrintWriter writer = new PrintWriter(new File(
				"I:\\Computer Science\\Mock Contests\\Mock Contests 2017\\Mock Contest November 16, 2017\\JudgesData\\gears.dat"));
		Scanner file;
		File[] files = new File("I:\\AAA\\").listFiles();
		writer.write(Integer.toString(files.length) + "\n");
		for(File f : files) {
			StringBuilder current = new StringBuilder();
			file = new Scanner(f);
			while(file.hasNext())
				current.append(file.nextLine());
			writer.write(current.toString() + "\n");
		}
		writer.close();
	}

	public static void shiftingGearsOut() throws IOException {
		PrintWriter writer = new PrintWriter(new File(
				"I:\\Computer Science\\Mock Contests\\Mock Contests 2017\\Mock Contest November 16, 2017\\JudgesData\\gears.out"));
		Files.lines(Paths.get(
				"I:\\Computer Science\\Mock Contests\\Mock Contests 2017\\Mock Contest November 16, 2017\\JudgesData\\gears.dat"))
				.skip(1)
				.map(str -> Arrays.stream(str.split("[^A-Z~!@#$%^&*()_+{}|:\"<>?]+")).filter(s -> !s.isEmpty())
						.toArray())
				.forEachOrdered(arr -> writer.write("The shift key was pressed " + arr.length + " times.\n"));
		writer.close();
	}

	public static void sadStatsStoryIn() throws IOException {
		PrintWriter writer = new PrintWriter(new File(
				"I:\\Computer Science\\Mock Contests\\Mock Contests 2017\\Mock Contest November 16, 2017\\JudgesData\\stats.dat"));
		writer.write((new Random()).ints(0, (int) (1e4)).distinct().limit(2017).mapToObj(Integer::toString)
				.collect(Collectors.joining(" ")));
		writer.close();
	}

	public static void sadStatsStoryOut() throws IOException {
		PrintWriter writer = new PrintWriter(new File(
				"E:\\Computer Science\\Mock Contests\\Mock Contests 2017\\Mock Contest November 16, 2017\\Data\\JudgesData\\stats.out"));
		Scanner file = new Scanner(new File(
				"E:\\Computer Science\\Mock Contests\\Mock Contests 2017\\Mock Contest November 16, 2017\\Data\\JudgesData\\stats.dat"));
		int[] nums = Arrays.stream(file.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
		double avg = Arrays.stream(nums).average().getAsDouble();
		writer.write(String.format("%.2f", Math.sqrt(
				IntStream.range(0, nums.length).mapToDouble(i -> avg - nums[i]).map(x -> x * x).sum() / (nums.length)))
				+ "\n");
		writer.close();
	}

	public static void romanNumeralTranslatorIn() throws IOException {
		int[] fibonacci = Stream.iterate(new int[] {1, 2}, x -> new int[] {x[1], x[0]+x[1]}).mapToInt(x -> x[0]).limit(15).toArray();
		PrintWriter writer = new PrintWriter(new File("I:\\Computer Science\\Mock Contests\\Mock Contests 2017\\Mock Contest November 16, 2017\\JudgesData\\roman.dat"));
		new Random().ints(0, fibonacci.length).distinct().limit(12).forEach(x -> {
			writer.write(toRoman(fibonacci[x]) + "\n");
			writer.write(Integer.toString(fibonacci[x]) + "\n");
		});
		writer.close();
	}
	
	public static void romanNumeralTranslatorOut() throws IOException {
		PrintWriter writer = new PrintWriter(new File("I:\\Computer Science\\Mock Contests\\Mock Contests 2017\\Mock Contest November 16, 2017\\SampleData\\roman.out"));
		Scanner file = new Scanner(new File("I:\\Computer Science\\Mock Contests\\Mock Contests 2017\\Mock Contest November 16, 2017\\SampleData\\roman.dat"));
		while(file.hasNext())
			writer.write((file.hasNextInt() ? toRoman(Integer.parseInt(file.nextLine())) : toArabic(file.nextLine())) + "\n");
		writer.close();
	}

	public static int toArabic(String str) {
		int n = 0, rightDigit = 0;
		for(int i = str.length() - 1; i >= 0; i--) {
			int value = (int) (Math.pow(10, "IXCM".indexOf(str.charAt(i)))
					+ 5 * Math.pow(10, "VLD".indexOf(str.charAt(i))));
			n += value * Math.signum(value - rightDigit + 0.5);
			rightDigit = value;
		}
		return n;
	}

	public static String toRoman(int n) {
		return String.join("", Collections.nCopies(n, "I")).replace("IIIII", "V").replace("IIII", "IV")
				.replace("VV", "X").replace("VIV", "IX").replace("XXXXX", "L").replace("XXXX", "XL").replace("LL", "C")
				.replace("LXL", "XC").replace("CCCCC", "D").replace("CCCC", "CD").replace("DD", "M")
				.replace("DCD", "CD");
	}
	
	public static void palindromeOut() throws IOException {
		PrintWriter writer = new PrintWriter(new File("I:\\Computer Science\\Mock Contests\\Mock Contests 2017\\Mock Contest November 16, 2017\\JudgesData\\tacocat.out"));
		Scanner file = new Scanner(new File("I:\\Computer Science\\Mock Contests\\Mock Contests 2017\\Mock Contest November 16, 2017\\JudgesData\\tacocat.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			String line = file.nextLine();
			char[] text = ('\0' + line.replaceAll("", ""+'\1') + '\2').toCharArray();
			int[] lengths = new int[text.length];
			int center = 0, right = 0, maxCenter = 0, maxLength = 0;
			for(int i = 1; i < text.length - 1; ++i) {
				int mirror = 2 * center - i;
				if(right > i)
					lengths[i] = Math.min(right - i, lengths[mirror]);
				while(text[i + (1 + lengths[i])] == text[i - (1 + lengths[i])])
					lengths[i]++;
				if(i + lengths[i] > right) {
					center = i;
					right = i + lengths[i];
				}
				if(lengths[i] > lengths[maxCenter]) {
					maxCenter = i;
					maxLength = lengths[i];
				}
			}
			int le = (maxCenter - maxLength) / 2,  ri = le + maxLength;
			writer.write(line.substring(le, ri) + "\n");
		}
		writer.close();
	}
	
	public static void crossOut() throws IOException {
		PrintWriter writer = new PrintWriter(new File("I:\\Computer Science\\Mock Contests\\Mock Contests 2017\\Mock Contest November 16, 2017\\JudgesData\\cross.out"));
		Scanner file = new Scanner(new File("I:\\Computer Science\\Mock Contests\\Mock Contests 2017\\Mock Contest November 16, 2017\\JudgesData\\cross.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			String[] words = file.nextLine().split("\\s");
			int commonA=-1, commonB=-1;
			for(commonA = 0; commonA < words[0].length(); ++commonA)
				if(words[2].indexOf(words[0].charAt(commonA)) > -1) {
					commonB = words[2].indexOf(words[0].charAt(commonA));
					break;
				}
			if(commonB == -1)
				writer.write("none\n");
			else {
				char[][] box = new char[words[2].length()][words[0].length()];
				for(int i = 0; i < box.length; ++i)
					for(int j = 0; j < box[0].length; ++j)
						box[i][j] = i == commonB ? words[0].charAt(j) : j == commonA ? words[2].charAt(i) : ' ';
				for(char[] row : box)
					writer.write(String.valueOf(row) + "\n");
			}
			writer.write("\n");
		}
		writer.close();
	}
	
	public static void dontRepeatYourselfOut() throws IOException {
		PrintWriter writer = new PrintWriter(new File("I:\\Computer Science\\Mock Contests\\Mock Contests 2017\\Mock Contest November 16, 2017\\JudgesData\\dry.out"));
		Scanner file = new Scanner(new File("I:\\Computer Science\\Mock Contests\\Mock Contests 2017\\Mock Contest November 16, 2017\\JudgesData\\dry.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			String str = file.nextLine(), ans = "";
			HashSet<Character> set = new HashSet<>();
			int i = 0, j = 0;
			while(i < str.length() && j < str.length())
				if(!set.contains(str.charAt(j))) {
					set.add(str.charAt(j++));
					if(j - i > ans.length())
						ans = str.substring(i, j);
				}
				else
					set.remove(str.charAt(i++));
			writer.write(ans + "\n");
		}
		writer.close();
	}
	
	public static void treasureMapOut() throws IOException {
		PrintWriter writer = new PrintWriter(new File("I:\\Computer Science\\Mock Contests\\Mock Contests 2017\\Mock Contest November 16, 2017\\JudgesData\\treasure.out"));
		Scanner file = new Scanner(new File("I:\\Computer Science\\Mock Contests\\Mock Contests 2017\\Mock Contest November 16, 2017\\JudgesData\\treasure.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			char[][] map = new char[10][10];
			for(int i = 0; i < 10; i++)
				map[i] = file.nextLine().toCharArray();
			file.nextLine();
			int islands = 0;
			for(int i = 0; i < 10; i++)
				for(int j = 0; j < 10; j++)
					if(map[i][j] == '#' && remove(map, i, j))
						islands++;
			writer.write(Integer.toString(islands) + "\n");
		}
		writer.close();
	}
	
	public static int[] mx = {1, 0, -1, 0}, my = {0, 1, 0, -1};
	public static boolean remove(char[][] map, int x, int y)
	{
		if(map[x][y] != '#')
			return true;
		map[x][y] = '.';
		boolean r = true;
		for(int q = 0; q < 4; q++)
			if(x+mx[q]<0 || x+mx[q]>9 || y+my[q]<0 || y+my[q]>9)
				r = false;
			else
				r &= remove(map, x+mx[q], y+my[q]);
		return r;
	}
	
	public static void gpaOut() throws IOException {
		PrintWriter writer = new PrintWriter(new File("E:\\Computer Science\\Mock Contests\\Mock Contests 2017\\Mock Contest November 16, 2017\\Data\\JudgesData\\gpa.out"));
		Scanner file = new Scanner(new File("E:\\Computer Science\\Mock Contests\\Mock Contests 2017\\Mock Contest November 16, 2017\\Data\\JudgesData\\gpa.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			int[] homew = Arrays.stream(file.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
			int[] tests = Arrays.stream(file.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
			writer.write(String.format("%.0f%n", Math.max(Arrays.stream(homew).sorted().skip(1).average().getAsDouble() * .5 + Arrays.stream(tests).sorted().average().getAsDouble() * 0.5, Arrays.stream(homew).sorted().average().getAsDouble() * .5 + Arrays.stream(tests).sorted().skip(1).average().getAsDouble() * 0.5)));
		}
		writer.close();
	}
}
