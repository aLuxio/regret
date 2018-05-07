package algorithms;

import java.util.Arrays;

public class LongestCommonSubsequence
{
	public static String lcs(String a, String b)
	{
		String[][] K = new String[a.length()+1][b.length()+1];
		for(String[] r : K)
			Arrays.fill(r, "");
		
		for(int x=1; x<K.length; x++)
		{
			for(int y=1; y<K[x].length; y++)
			{
				if(a.charAt(a.length()-x) == b.charAt(b.length()-y))
					K[x][y] = a.charAt(a.length()-x) + K[x-1][y-1];
				else
				{
					String c=K[x-1][y], d=K[x][y-1];
					K[x][y] = c.length() > d.length() ? c : d;
				}
			}
		}
		
		return K[a.length()][b.length()];
	}
	
	public static void main(String[] args)
	{
		String a = "nematodeknowledge", b = "emptybottle";
		System.out.println(lcs(a, b));
	}
}
