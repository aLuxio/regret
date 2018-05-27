package Region.reg2017.A;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Fabiana {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/Region/reg2017/data/judgedata/fabiana.dat"));
		while(file.hasNext()) {
			String s = file.next();
			int pos = Integer.parseInt(file.nextLine().trim());
			Node root = null;
			for(char c : s.toCharArray())
				root = insert(root, c);
			int c = 0;
			for(int i = 0; i <= pos; ++i)
				if(s.charAt(i) == s.charAt(pos))
					c++;
			int depth = -1;
			while(root != null && c > 0) {
				depth++;
				if(s.charAt(pos) > root.val)
					root = root.r;
				else {
					if(root.val == s.charAt(pos))
						c--;
					root = root.l;
				}
			}
			System.out.println(depth);
		}
		file.close();
	}
	static Node insert(Node root, char v) {
		if(root == null)
			return new Node(v);
		if(v <= root.val)
			root.l = insert(root.l, v);
		else
			root.r = insert(root.r, v);
		return root;
	}

	static class Node {
		Node r, l;
		char val;

		public Node(char v) {
			val = v;
		}
	}
}
