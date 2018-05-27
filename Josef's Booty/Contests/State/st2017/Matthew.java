package State.st2017;

import java.util.*;
import java.util.regex.*;
import java.io.*;
public class Matthew
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("src\\State\\st2017\\data\\matthew.dat"));
		while(file.hasNext())
		{
			String phrase = file.nextLine();
			int queries = file.nextInt();
			file.nextLine();
			for(int i = 0; i < queries; i++)
			{
				String q = file.nextLine().trim();
				q = "\\b" + q.replace("?", "\\S").replace("*", "\\S*") + "\\b";
				Matcher m = Pattern.compile(q).matcher(phrase);
				List<String> results = new ArrayList<String>();
				while(m.find())
					results.add(m.group());
				System.out.println(results.isEmpty() ? "NONE" : String.join(" ", results));
			}
		}
	}
}
