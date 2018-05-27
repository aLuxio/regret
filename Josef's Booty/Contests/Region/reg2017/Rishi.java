package Region.reg2017;

import java.util.*;
import java.io.*;
public class Rishi
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("src\\Regional2017\\rishi.dat"));
		while(file.hasNext())
		{
			String cheese = file.nextLine();
			String result = "";
			if(Character.isDigit(cheese.charAt(0)))
			{
				String[] nums = cheese.split("[A-Z]");
				String[] wrds = cheese.split("\\d+");
				for(int i = 0; i < nums.length; i++)
					result += String.join("", Collections.nCopies(Integer.parseInt(nums[i]), wrds[i+1]));
			}
			else
			{
				int c = 1;
				for(int i = 0; i < cheese.length()-1; i++)
					if(cheese.charAt(i) == cheese.charAt(i + 1))
						c++;
					else
					{
						result += "" + c + cheese.charAt(i);
						c = 1;
					}
				result += "" + c + cheese.charAt(cheese.length() - 1);
			}
			System.out.println(result);
		}
	}
}
