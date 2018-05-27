package Region.reg2015;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class CodeQuality {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/Region/reg2015/data/studentdata/codequality.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			int lines = Integer.parseInt(file.nextLine());
			String s = file.nextLine();
			for(int i = 1; i < lines; ++i)
				s += file.nextLine();
			int[] brac = new int[3];
			int off = -1;
			Stack<Character> stack = new Stack<>();
			for(int i = 0; i < s.length(); ++i)
				if("{[(".contains(Character.toString(s.charAt(i)))) {
					stack.push(s.charAt(i));
					brac["{[(".indexOf(s.charAt(i))] += 2;
				}
				else if("}])".contains(Character.toString(s.charAt(i))))
					if(stack.isEmpty() || "{[(".indexOf(stack.peek()) != "}])".indexOf(s.charAt(i)))
						off = i;
					else
						stack.pop();
				else
					continue;
			System.out.println(
					off == -1 ? ("YES " + brac[2] + " () " + brac[1] + " [] " + brac[0] + " {}") : ("NO " + off));

		}
		file.close();
	}
}
