/*import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class gears
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data\\gears.dat"));
		int oof = file.nextInt();
		file.nextLine();
		
		for(int a=0; a<oof; a++)
		{
			String line = file.nextLine();
			int count =0;
			for(int b=0; b<line.length(); b++)
			{
				out.print(line.substring(b, b+1));
				if(line.substring(b,b+1).matches("[A-Z\\~\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\_\\+\\{\\}\\|\\:\"\\<\\>\\?]+")) {
					count++;
				}
			}
			out.println("The shift key was pressed "+count+" times.");
		}
	}
}*/