package District.dis2016;

import java.util.*;
import java.io.*;
public class Violeta
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("src\\District\\dis2016\\data\\violeta.dat"));
		int T = file.nextInt();
		file.nextLine();
		for(; T > 0; --T)
			System.out.println(manacher(file.nextLine()));
	}

	public static String manacher(String line)
	{
		char[] text = ("$" + line.replaceAll("", "#") + "@").toCharArray();
		int[] lengths = new int[text.length];
		int center = 0, right = 0, maxCenter = 0, maxLength = 0;
		for(int i = 1; i < text.length - 1; i++)
		{
			int mirror = 2 * center - i;
			if(right > i)
				lengths[i] = Math.min(right - i, lengths[mirror]);
			while(text[i + (1 + lengths[i])] == text[i - (1 + lengths[i])])
				lengths[i]++;
			if(i + lengths[i] > right)
			{
				center = i;
				right = i + lengths[i];
			}
			if(lengths[i] > lengths[maxCenter])
			{
				maxCenter = i;
				maxLength = lengths[i];
			}
		}
		int le = (maxCenter - maxLength) / 2;
		int ri = le + maxLength;
		return line.substring(le, ri);
	}
}
