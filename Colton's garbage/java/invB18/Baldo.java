package invB18;

import static java.lang.System.*;

public class Baldo
{
	public static void main(String[] args)
	{
		for(char cap = 'A', low = 'a'; cap<='Z'; cap++, low++)
			out.printf("%c %d %c %d%n", cap, (int)cap, low, (int)low);
	}
}
