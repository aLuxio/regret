package mockContest2;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Statistics
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data\\mc1116\\SampleData\\stats.dat"));
		
		while(file.hasNext())
		{
			Scanner line = new Scanner(file.nextLine());
			List<Integer> data = new ArrayList<>();
			while(line.hasNext())
				data.add(Integer.parseInt(line.next()));
			double stDev = 0;
			double mean = mean(data);
			for(int i : data)
				stDev += Math.pow(mean-i, 2);
			stDev /= data.size();
			stDev = Math.sqrt(stDev);
			out.printf("%.2f", stDev);
			line.close();
		}
		file.close();
	}
	
	public static double mean(List<Integer> in)
	{
		double mean = 0;
		for(int i : in)
			mean += i;
		mean /= in.size();
		return mean;
	}
}
