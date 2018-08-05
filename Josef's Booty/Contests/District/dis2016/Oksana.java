package District.dis2016;

import java.util.Collections;
public class Oksana {
	public static void main(String[] args) {
		for(int i = 0; i < 8; i++)
			System.out.println(String.join(" ", Collections.nCopies(8, "*")));
	}
}
