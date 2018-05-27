package State.st2018;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Oscar {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/State/st2018/data/judgesData/oscar.dat"));
		while(file.hasNext()) {
			LinkedList<String> text = new LinkedList<String>(Arrays.asList(file.nextLine().split("\\s")));
			LinkedList lines[] = { new LinkedList<String>(), new LinkedList<String>(), new LinkedList<String>() };
			if(text.stream().anyMatch(s -> s.length() > 10))
				System.out.println("SIGN CANNOT BE MADE");
			else {
				if(text.size() == 1)
					lines[1].add(text.pop());
				else if(text.size() <= 3)
					for(int i = 0; i < 3 && !text.isEmpty(); ++i)
						lines[i].add(text.pop());
				else {
					int i = 0, index = 0, len[] = new int[3];
					while(!text.isEmpty() && index < 3)
						if(len[index] + text.peek().length() + lines[index].size() <= 10) {
							lines[index].add(text.peek());
							len[index] += text.pop().length();
						} else
							index++;
					for(int realignment = 0; realignment < 3; ++realignment)
					for(int pos = 2; pos > 0; --pos)
						if(lines[pos].isEmpty() && !lines[pos - 1].isEmpty())
							lines[pos].add(lines[pos - 1].pollLast());
				}
				char[][] sign = new char[5][12];
				for(int row = 0; row < 5; ++row)
					if(row == 0 || row == 4)
						Arrays.fill(sign[row], '*');
					else {
						String data = String.join(".", lines[row - 1]);
						Arrays.fill(sign[row], '.');
						sign[row][0] = sign[row][11] = '*';
						System.arraycopy(data.toCharArray(), 0, sign[row], (12 - data.length()) / 2, data.length());
					}
				if(text.isEmpty())
					for(char[] row : sign)
						System.out.println(row);
				else
					System.out.println("SIGN CANNOT BE MADE");
			}
			System.out.print(file.hasNext() ? "\n" : "");
		}
		file.close();
	}
}
