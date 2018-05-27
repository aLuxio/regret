import java.io.*;
import java.util.*;
import java.math.*;
public class TanviRF
{
	public static void main(String[] args) throws IOException
	{
		Scanner f = new Scanner(new File("tanvi2.dat"));
		int lool = Integer.parseInt(f.nextLine());
		while(lool-->0)
		{
			int num = f.nextInt();
			f.nextLine();
			String[] arr = f.nextLine().split("[, ]+");
			ArrayList<Job> jobs = new ArrayList<Job>();
			for(int i =0 ; i< arr.length; i+=2)
			{
				jobs.add(new Job(Integer.parseInt(arr[i].substring(1,3)) * 60 + Integer.parseInt(arr[i].substring(4,6)),  Integer.parseInt(arr[i + 1].substring(0,2)) * 60 + Integer.parseInt(arr[i + 1].substring(3,5))));
			}
			if(jobs.size() > 0){
			Collections.sort(jobs);
			ArrayList<Job> take = new ArrayList<>();
			take.add(jobs.get(0));
			for(int i = 1; i < jobs.size(); i++)
				if(jobs.get(i).start >= take.get(take.size() - 1).end)
					take.add(jobs.get(i));
			for(Job x: take)
			{
				System.out.print(x.toString() + " ");
			}}
			System.out.println();
				
		}
	}
}

class Job implements Comparable<Job>
{
	int start;
	int end;
	public Job(int s, int e)
	{
		start = s;
		end = e;
	}
	
	public int compareTo(Job x)
	{
		return this.end - x.end;
	}
	
	public String toString()
	{
		String x = "[";
		x += start/60 > 9 ? start/60: "0"+start/60;
		x+= ":";
		x+= start%60 > 9 ? start%60: "0" + start%60;
		x+= ", ";
		x += end/60 > 9 ? end/60: "0"+end/60;
		x+= ":";
		x+= end%60 > 9 ? end%60: "0" + end%60;
		return x+"]";
		
	}
}
