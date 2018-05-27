package State.st2017;

public class Arun {
	public static void main(String[] args) {
		String s = "STATEUILCOMPUTERSCIENCEPROGRAMMINGCONTEST";
		for(int i = 0; i < s.length(); ++i) {
			for(int j = 0; j < s.length(); ++j)
				System.out.print(i%3==0?s.charAt(i):i%3==1?s.charAt(j):s.charAt(s.length()-1-j));
			System.out.println();
		}
	}
}
