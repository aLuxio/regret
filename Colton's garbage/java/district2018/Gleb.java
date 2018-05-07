package district2018;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Gleb
{
	static char[] notes = {'C', 'D', 'E', 'F', 'G', 'A', 'B'};
	
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data/district2018/studentdata/gleb.dat"));
		
		while(file.hasNext())
		{
			String temp = file.nextLine();
			String root = temp.substring(0, temp.indexOf(" "));
			int[] lol = Arrays.stream(temp.substring(temp.indexOf(" ")+1).split("\\s+"))
					.mapToInt(Integer::parseInt)
					.toArray();
			
			String melody = root;
			root = temp.substring(0, 1);
			int octave = Integer.parseInt(root.substring(1));
			
			for(int r : lol)
			{
				
			}
		}
	}
	
	public static int indexOf(char n)
	{
		int i=0;
		for(; i<notes.length; i++)
			if(notes[i]==n) break;
		return i;
	}
}
