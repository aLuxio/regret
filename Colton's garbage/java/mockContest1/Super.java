package mockContest1;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Super {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("data\\mc1017\\JudgesData\\super.dat"));
		int count = file.nextInt();
		
		for(int i=0; i<count; i++)
		{
			int a = file.nextInt(),
				b = file.nextInt(),
				c = file.nextInt(),
				d = file.nextInt(),
				e = file.nextInt(),
				f = file.nextInt();
			
			int damage = (((((a * 2 / 5) + 2) * b * c / 50) / e) + 2) * d / 100;
			
			out.println(damage >= f ? "Wow!! That was SUPER EFFECTIVE!!!" : "...");
		}
		
		file.close();
	}
}
