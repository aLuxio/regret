package State.st2017;
import java.util.*;
import java.io.*;
public class Rohan
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("src/State//st2017//data//rohan.dat"));
		while(file.hasNext())
		{
			double Xa = file.nextDouble(), Ya = file.nextDouble();
			double Xb = file.nextDouble(), Yb = file.nextDouble();
			double Xc = file.nextDouble(), Yc = file.nextDouble();
			double lenA = Math.sqrt((Xb-Xc)*(Xb-Xc) + (Yb-Yc)*(Yb-Yc));
			double lenB = Math.sqrt((Xa-Xc)*(Xa-Xc) + (Ya-Yc)*(Ya-Yc));
			double lenC = Math.sqrt((Xb-Xa)*(Xb-Xa) + (Yb-Ya)*(Yb-Ya));
			double incX = (lenA*Xa + lenB*Xb + lenC*Xc) / (lenA + lenB + lenC);
			double incY = (lenA*Ya + lenB*Yb + lenC*Yc) / (lenA + lenB + lenC);
			double cenX = (Xa + Xb + Xc) / 3;
			double cenY = (Ya + Yb + Yc) / 3;
			double semiP = (lenA + lenB + lenC) / 2;
			double area = Math.sqrt(semiP * (semiP - lenA) * (semiP - lenB) * (semiP - lenC));
			System.out.format("(%.2f,%.2f)%n(%.2f,%.2f)%n%.2f%n", incX, incY, cenX, cenY, area);
		}
	}
}
