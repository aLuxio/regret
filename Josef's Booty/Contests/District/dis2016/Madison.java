package District.dis2016.A;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Madison {
	public static void main(String[] args) throws IOException, ScriptException {
		Scanner file = new Scanner(new File("src/District/dis2016/data/madison.dat"));
		while(file.hasNext()) {
			String[] s = (file.nextLine() + "000").split("\\s");
			s[0] = s[0].replace("A", s[1].charAt(0) == '1' ? "true" : "false")
					.replaceAll("B", s[1].charAt(1) == '1' ? "true" : "false")
					.replaceAll("C", s[1].charAt(2) == '1' ? "true" : "false").replaceAll("\\*", "&&")
					.replaceAll("\\+", "||").replace("^", "!=");
			System.out.println(new ScriptEngineManager().getEngineByName("js").eval(s[0]));
		}
		file.close();
	}
}
