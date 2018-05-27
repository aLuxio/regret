package Region.reg2018;

public class Ariana {
	public static void main(String[] args) {
		String[] s = "i must not tell lies.".split("\\s");
		for(int i = 1, pos = 0, inc = 1; i <= 40; ++i, pos += inc, inc = pos == 0 || pos == 4 ? inc * -1 : inc) {
			System.out.format("%-3d", i);
			for(int a = 0; a < s.length; ++a)
				System.out.print((a == pos ? s[a].toUpperCase() : s[a]) + " ");
			System.out.println();
		}
	}
}
