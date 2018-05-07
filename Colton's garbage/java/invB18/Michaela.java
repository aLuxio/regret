// **This one uses the longest common subsequence algorithm!***

package invB18;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Michaela
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data/invB2018/judgedata/micaela.dat"));
		
		while(file.hasNext())
			out.println(lcs(file.next(), file.next()));
		
		file.close();
	}
	
	public static String lcs(String a, String b)
	{
		String[][] dp = new String[a.length() + 1][b.length() + 1];
		
		for(String[] r : dp)
			Arrays.fill(r, "");
		
		for(int i=1; i<dp.length; i++)
		{
			for(int j=1; j<dp[0].length; j++)
			{
				if(a.charAt(a.length()-i) == b.charAt(b.length()-j))
					dp[i][j] = a.charAt(a.length()-i) +dp[i-1][j-1];
				else
				{
					String c = dp[i-1][j], d = dp[i][j-1];
					dp[i][j] = c.length() > d.length() ? c : d;
				}
			}
		}
		return dp[a.length()][b.length()].isEmpty() ? "NONE" :
			dp[a.length()][b.length()];
	}
}
