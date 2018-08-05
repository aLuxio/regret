package District.dis2016;

import java.util.*;
import java.io.*;
public class Nicholas {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src\\District\\dis2016\\data\\nicholas.dat"));
		while(file.hasNext()) {
			int nodes = file.nextInt(), pow = file.nextInt();
			String mat = file.nextLine();
			int[][] adj = new int[nodes][nodes];
			int[][] res = new int[nodes][nodes];
			for(int i = 0; i < nodes; i++) {
				adj[i] = mat.trim().split(" ")[i].chars().map(x -> x - '0').toArray();
				res[i] = mat.trim().split(" ")[i].chars().map(x -> x - '0').toArray();
			}
			while(pow-- > 1)
				res = multiply(adj, res);
			System.out.println(Arrays.stream(res).flatMapToInt(x -> Arrays.stream(x)).sum());
		}
	}

	public static int[][] multiply(int[][] a, int[][] b) {
		int[][] c = new int[a.length][b[0].length];
		for(int i = 0; i < a.length; i++)
			for(int j = 0; j < b[0].length; j++)
				for(int k = 0; k < b.length; k++)
					c[i][j] += a[i][k] * b[k][j];
		return c;
	}
}
