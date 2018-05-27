package State.st2017;
import java.util.*;
import java.io.*;
public class Yulia
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("src\\State\\st2017\\data\\yulia.dat"));
		int a = file.nextInt();	file.nextLine();
		for(; a > 0; a--)
		{
			int b = file.nextInt();	file.nextLine();
			char[][] c = new char[b][b];
			for(int d = 0; d < b; d++)
				c[d] = file.nextLine().toCharArray();
			ArrayList<String> e = new ArrayList<>(), ex = new ArrayList<>();;
			String f = file.nextLine();
			for(char[] row : c)
				e.add(String.valueOf(row));
			for(int g = 0; g < b; g++)
			{
				String word = "";
				for(int h = 0; h < b; h++)
					word += c[h][g];
				e.add(word);
			}
			for(String word : e.subList(0, e.size()))
				for(int i = 0; i < word.length(); i++)
					for(int j = 1; j <= word.length()-i; j++)
						ex.add(word.substring(i, i+j));
			e.addAll(ex);
			int min = Integer.MAX_VALUE, k = 0, dist;
			while(k < e.size() && min != 0)
				if((dist = levenshtein(f, e.get(k++))) < min)
					min = dist;
			System.out.println(f.length() - min);
		}
	}
	public static int levenshtein(String a, String b)
	{
		a = a.toLowerCase();
		b = b.toLowerCase();
		int[][] box = new int[a.length()+1][b.length()+1];
		for(int i = 0; i <= a.length(); i++)
			box[i][0] = i;
		for(int i = 0; i <= b.length(); i++)
			box[0][i] = i;
		for(int i = 1; i <= a.length(); i++)
			for(int j = 1; j <= b.length(); j++)
				box[i][j] = Math.min(box[i-1][j]+1, Math.min(box[i][j-1]+1, box[i-1][j-1] + (a.charAt(i-1)==b.charAt(j-1)?0:1)));
		return box[a.length()][b.length()];
	}
}
