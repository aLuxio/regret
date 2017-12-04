package district2017;
import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Gan
{

    public static void main(String[] args) throws IOException
    {
    	final double PI = 3.141592653589793;
    	Scanner file = new Scanner(new File("2017 District\\JudgeData\\gan.dat"));
    	out.println("--------------------------------------");
    	
    	while(file.hasNext())
    	{
    		int radius = file.nextInt();
    		double circumference = 2 * PI * radius;
    		double area = PI * Math.pow(radius, 2);
    		double surfaceArea = 4 * PI * Math.pow(radius, 2);
    		double volume = (4.0/3) * PI * Math.pow(radius, 3);
    		
    		out.printf("%2d%9.1f%9.1f%9.1f%9.1f\n", radius, circumference, area, surfaceArea, volume);
    		
    	}
    	out.println("--------------------------------------");
    }
    
    
}