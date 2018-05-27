package mockContests.december2017.advanced;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class Balance {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/december2017/advanced/data/judgesdata/balance.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T)
			System.out.println(isValidExpression(file.nextLine()) ? "YES" : "NO");
		file.close();
	}

	public static boolean isValidExpression(String expression) {
		Stack<Character> symbols = new Stack<Character>();
		for(char symb : expression.toCharArray())
			if(Character.toString(symb).matches("[" + Pattern.quote("{(<[") + "]"))
				symbols.push(symb);
			else if(Character.toString(symb).matches("[" + Pattern.quote("})>]") + "]")) {
				if(symbols.isEmpty())
					return false;
				else if(symbols.peek() == (symb - (symb == ')' ? 1 : 2)))
					symbols.pop();
				else
					return false;
			}
		return symbols.isEmpty();
	}
}
