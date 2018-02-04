package katyTaylor17;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

//.nisdMMXVII

public class Anagram
{

	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data\\kaTay17\\anagram.in"));
		int count = file.nextInt();
		file.nextLine();
		
		for(int a=0; a<count; a++)
		{
			String lineA = file.next();
			String lineB = file.nextLine();
			
			int[] freq = new int[26];
			for(char let : lineA.toCharArray())
				freq[let-'A']++;
			for(char jeff : lineB.toCharArray())
				freq[jeff-'A']--;
			
			boolean chk = true;
			for(int ind : freq)
			{
				if(ind!=0)
					chk = false;
			}
			if(chk)
				out.println("ANAGRAM");
			//else
				
		}
	}

}
