package mockContests.january2018.advanced;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Treasury {
	public static void main(String[] args) throws IOException {
		arrayBasedTree();
		nodeBasedTree();
	}

	public static void arrayBasedTree() throws FileNotFoundException {
		Scanner file = new Scanner(new File("src/mockContests/january2018/data/judgesdata/ust.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			HashMap<Integer, Integer> count = new HashMap<>();
			Integer[] tree = new Integer[(int) Math.pow(2, 25)];
			Arrays.stream(file.nextLine().split(",")).map(Integer::parseInt).forEachOrdered(x -> {
				count.merge(x, 1, Integer::sum);
				int index = 0;
				if(tree[0] == null)
					tree[0] = x;
				else {
					while(tree[index] != x && tree[index] != null)
						index = 2 * index + (tree[index] > x ? 1 : 2);
					if(tree[index] == null)
						tree[index] = x;
				}
			});
			LinkedList<String> traversal = new LinkedList<>();
			LinkedList<Integer> queue = new LinkedList<>();
			queue.add(0);
			while(!queue.isEmpty()) {
				int index = queue.pop();
				if(index >= tree.length || tree[index] == null)
					continue;
				queue.push(2 * index + 1);
				queue.push(2 * index + 2);
				traversal
						.addFirst(tree[index] + (count.get(tree[index]) > 1 ? "(" + count.get(tree[index]) + ")" : ""));
			}
			System.out.println("[" + String.join(" ", traversal) + "]");
		}
		file.close();
	}

	public static void nodeBasedTree() throws IOException {
		Scanner file = new Scanner(new File("src/mockContests/january2018/data/judgesdata/ust.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			Tree tree = new Tree();
			for(String s : file.nextLine().split(","))
				tree.insert(Integer.parseInt(s));
			List<String> post = new LinkedList<>();
			tree.postOrder(tree.root, post);
			System.out.println(post.toString().replace(",", ""));
		}
		file.close();
	}

	static class Tree {
		static class Node {
			Node left, right;
			int val, cnt;

			public Node(int n) {
				val = n;
				cnt = 1;
			}
		}

		Node root;

		public void insert(int n) {
			root = insert(root, n);
		}

		public Node insert(Node node, int n) {
			if(node == null)
				node = new Node(n);
			else if(n < node.val)
				node.left = insert(node.left, n);
			else if(n > node.val)
				node.right = insert(node.right, n);
			else
				node.cnt++;
			return node;
		}

		public void postOrder(Node n, List<String> traversal) {
			if(n == null)
				return;
			postOrder(n.left, traversal);
			postOrder(n.right, traversal);
			traversal.add(n.val + (n.cnt > 1 ? "(" + n.cnt + ")" : ""));
		}
	}
}
