package district2018;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Max
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data/district2018/judgedata/max.dat"));
		Map<Character, String> alpha = new HashMap<>();
		
		alpha.put('A', "Alpha");
		alpha.put('B', "Bravo");
		alpha.put('C', "Charlie");
		alpha.put('D', "Delta");
		alpha.put('E', "Echo");
		alpha.put('F', "Foxtrot");
		alpha.put('G', "Golf");
		alpha.put('H', "Hotel");
		alpha.put('I', "India");
		alpha.put('J', "Juliet");
		alpha.put('K', "Kilo");
		alpha.put('L', "Lima");
		alpha.put('M', "Mike");
		alpha.put('N', "November");
		alpha.put('O', "Oscar");
		alpha.put('P', "Papa");
		alpha.put('Q', "Quebec");
		alpha.put('R', "Romeo");
		alpha.put('S', "Sierra");
		alpha.put('T', "Tango");
		alpha.put('U', "Uniform");
		alpha.put('V', "Victor");
		alpha.put('W', "Whiskey");
		alpha.put('X', "Xray");
		alpha.put('Y', "Yankee");
		alpha.put('Z', "Zulu");
		alpha.put('0', "Zero");
		alpha.put('1', "Wun");
		alpha.put('2', "Too");
		alpha.put('3', "Tree");
		alpha.put('4', "Fower");
		alpha.put('5', "Fife");
		alpha.put('6', "Six");
		alpha.put('7', "Seven");
		alpha.put('8', "Ait");
		alpha.put('9', "Niner");
		
		while(file.hasNext())
		{
			char[] xd = file.nextLine().toCharArray();
			String lol = "";
			
			for(char i : xd)
				lol += alpha.get(i) + " ";
			
			out.println(lol.trim());
		}
		
		file.close();
	}
}
