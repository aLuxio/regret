package invB18;

import static java.lang.System.*;
import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class Dilbert
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("data/invB2018/StudentData/dilbert.dat"));
		
		List<Person> people = new ArrayList<>();
		
		while(file.hasNext())
		{
			Person temp = new Person(file.next(), file.next());
			if(people.contains(temp))
			temp.add(file.next(), file.nextDouble());
			
		}
	}
	
	static class Sale implements Comparable<Sale>
	{
		LocalDate date;
		double amount;
		
		public Sale(String date, double a)
		{
			int[] d = Arrays.stream(date.split("/")).mapToInt(Integer::parseInt).toArray();
			this.date = LocalDate.of(d[2], d[0], d[1]);
			amount = a;
		}
		
		public int compareTo(Sale other)
		{
			return date.compareTo(other.date);
		}
		
		public String toString()
		{
			return String.format("%d/%d/%d $.2f", date.getMonthValue(), date.getDayOfMonth(), date.getYear(), amount);
		}
	}
	
	static class Person implements Comparable<Person>
	{
		String first, last;
		ArrayList<Sale> sales;
		
		public Person(String f, String l)
		{
			first = f;
			last = l;
			sales = new ArrayList<>();
		}
		
		public void add(String date, double amnt)
		{
			sales.add(new Sale(date, amnt));
		}
		
		public double getTotal()
		{
			return sales.stream().mapToDouble(i -> i.amount).sum();
		}
		
		public int compareTo(Person other)
		{
			if(this.getTotal() < other.getTotal())
				return -1;
			if(this.getTotal() > other.getTotal())
				return 1;
			return 0;
		}
		
		public String toString()
		{
			String temp = "";
			for(Sale i : sales)
				temp += i+"\n";
			return String.format("%s %s%n%sTotal Sales: $%.2f", first, last, temp, getTotal());
		}
	}
}
