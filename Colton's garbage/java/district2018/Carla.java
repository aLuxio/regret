package district2018;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Carla
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data/district2018/judgedata/carla.dat"));
		
		while(file.hasNext())
		{
			String ugu = "";
			char[] lol = file.next().toCharArray();
			
			for(char i : lol)
			{
				if(!Character.isDigit(i))
				{
					switch(i)
					{
						case 'D': ugu += "d"; break;
						case 'F': ugu += "-"; break;
						case 'L': ugu += "l"; break;
					}
				}
				else
				{
					String[] h = {"r", "w", "x"};
					String num = Integer.toBinaryString(Character.digit(i, 8));
					while(num.length() < 3)
						num = "0" + num;
					for(int b=0; b<h.length; b++)
					{
						if(b==3)
							b = 0;
						
						if(num.charAt(b) == '1')
							ugu += h[b];
						else
							ugu += "-";
					}
				}
			}
			
			out.println(ugu);
		}
		
		file.close();
	}
}
