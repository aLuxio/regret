package State.st2017;
import java.util.*;
import java.io.*;
public class Christina
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("src\\State\\st2017\\data\\christina.txt"));
		int a = file.nextInt();
		file.nextLine();
		String[] names = new String[a];
		for(int b = 0; b < a; b++)
			names[b] = file.nextLine();
		while(file.hasNext())
		{
			StringBuilder c = new StringBuilder();
			for(String d : file.nextLine().split("(?<=\\G.{3})"))
			{
				String e = names[Integer.parseInt(d.substring(0, 2))-1], f = "";
				switch(d.charAt(2)){
					case 'u' : f = new StringBuilder(e.toUpperCase()).reverse().toString();	break;
					case 'l' : f = new StringBuilder(e.toLowerCase()).reverse().toString();	break;
					case 'U' : f = e.toUpperCase();	break;
					case 'L' : f = e.toLowerCase();	break;
					case 'R' : f = new StringBuilder(e).reverse().toString();	break;
				}
				c.append(f);
			}
			System.out.println(c);
		}
	}
}
