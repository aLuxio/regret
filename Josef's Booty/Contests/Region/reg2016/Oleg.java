package Region.reg2016;

import java.util.*;
import java.io.*;
public class Oleg
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("src\\Region\\reg2016\\data\\oleg.txt"));
		while(file.hasNext())
		{
			String game = file.nextLine();
			System.out.println(game);
			char[][][] board = new char[3][3][3];
			for(int i = 0, ind = 0; i < 3; i++)
				for(int j = 0; j < 3; j++)
					for(int k = 0; k < 3 && ind < 27; k++, ind++)
						board[i][j][k] = game.charAt(ind);
			System.out.println(Arrays.deepToString(board).replaceAll("(?<=\\]),\\s(?=\\[)", "\n"));
			
			System.out.println();
		}
		file.close();
	}
}
