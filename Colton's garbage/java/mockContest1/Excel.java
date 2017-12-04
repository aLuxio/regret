package mockContest1;

import static java.lang.System.*;
import java.util.*;
import java.io.*;


public class Excel
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data\\mc1017\\JudgesData\\excel.dat"));
		int count = file.nextInt();
		
		for(int a=0; a<count; a++)
		{
			StringBuffer joj = new StringBuffer("");
			int num = file.nextInt();
			Map<Integer, String> map = new TreeMap<>();

			char val = 'A';
			for(int key=0; key<26; key++)
			{
				map.put(key, Character.toString(val++));
			}
			
			//out.println(map);
			
			while(num-- > 0)
			{
				joj.append(map.get(num % 26));
				num /= 26;
			}
			if(map.containsKey(num))
				joj.append(map.get(num));
			
			joj.reverse();
			out.println(joj.toString());
		}
		
		file.close();
	}
}
