package invB18;

import static java.lang.System.*;
import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Constanza
{
	public static void main(String[] args) throws IOException
	{
		Map<String, String> gay = new LinkedHashMap<>();
		gay.put("red", "");
		gay.put("orange", "");
		gay.put("yellow", "");
		gay.put("green", "");
		gay.put("blue", "");
		gay.put("indigo", "");
		gay.put("violet", "");
		
		Files.lines(Paths.get("data/invB2018/JudgeData/constanza.dat"))
			.forEach(a -> gay.put(a, gay.get(a)+"*"));
		
		for(String i : gay.keySet())
			out.println(i+"\t"+gay.get(i));
	}
}
