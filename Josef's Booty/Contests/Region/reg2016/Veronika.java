package Region.reg2016;

import java.util.*;
import java.io.*;
public class Veronika
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("src\\Region\\reg2016\\data\\veronika.txt"));
		while(file.hasNext())
		{
			String word = file.nextLine();
			char[][] box = new char[word.length() * 2 - 1][word.length() * 2 - 1];
			int j = 0;
			int[] mx = {1, 0, -1, 0};
			int[] my = {0, 1, 0, -1};
			j = my[1] + mx[1];
			for(int i = 0; i < box.length; i++)
				while(j != word.length())
				{
					
				}
			for(char[] row : box)
				System.out.println(String.valueOf(row));
			System.out.println();
		}
		file.close();
	}
}
