package Region.reg2016;

import java.nio.file.*;
import java.util.*;
import java.io.*;
public class Thiago
{
	public static void main(String[] args) throws IOException
	{
		List<String> list = Files.readAllLines(Paths.get("src\\Region\\reg2016\\data\\thiago.txt"));
		for(String name : list)
			System.out.println(name + " " + name.toUpperCase().chars().sum() * list.size());
	}
}
