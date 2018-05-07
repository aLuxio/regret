package invB18;

import static java.lang.System.*;
import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Judith
{
	public static void main(String[] args) throws IOException
	{
		Files.lines(Paths.get("data/invB2018/judgedata/judith.dat"))
			.map(x -> new BigDecimal(x))
			.sorted()
			.forEachOrdered(out::println);
	}
}
