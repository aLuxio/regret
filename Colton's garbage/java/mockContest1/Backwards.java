//Mock Contest 10-17-2017 - Problem 3 - Backwards

package mockContest1;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Backwards
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data\\mc1017\\JudgesData\\back.dat"));
		int count = file.nextInt();
		file.nextLine();
		
		for(int a=0; a<count; a++)
		{
			String word = file.nextLine();
			StringBuffer backWord = new StringBuffer(word);
			backWord.reverse();
			
			out.println(word.equals(backWord.toString()) ? "SAME" : "NOT SAME");
			//out.println(word + " | " + backWord.toString());
		}
		
		file.close();
	}
}
