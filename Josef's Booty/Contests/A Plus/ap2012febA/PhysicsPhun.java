package APlus.ap2012febA;

import java.io.*;
import java.util.*;

public class PhysicsPhun {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("physicsphun.dat"));
		for(int T = file.nextInt(); T > 0; --T) {
			System.out.printf("x = %.3f%n",
					Math.pow(file.nextDouble(), 2) * Math.sin(2 * Math.toRadians(file.nextDouble())) / 9.8);
		}
	}
}
