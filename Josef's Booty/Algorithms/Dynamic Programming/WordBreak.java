package algorithms.dynamicProgramming;

import java.util.*;
import java.io.*;
public class WordBreak {
	public static void main(String[] args) {
		System.out.println(wordBreak("ilikesamsung", new HashSet<String>(){{add("mobile");add("samsung");add("sam");add("sung");add("man");add("mango");add("icecream");add("and");add("go");add("i");add("like");add("ice");add("cream");}}));
		System.out.println(wordBreak("iiiiiiii", new HashSet<String>(){{add("mobile");add("samsung");add("sam");add("sung");add("man");add("mango");add("icecream");add("and");add("go");add("i");add("like");add("ice");add("cream");}}));
		System.out.println(wordBreak("", new HashSet<String>(){{add("mobile");add("samsung");add("sam");add("sung");add("man");add("mango");add("icecream");add("and");add("go");add("i");add("like");add("ice");add("cream");}}));
		System.out.println(wordBreak("ilikelikeimangoiii", new HashSet<String>(){{add("mobile");add("samsung");add("sam");add("sung");add("man");add("mango");add("icecream");add("and");add("go");add("i");add("like");add("ice");add("cream");}}));
		System.out.println(wordBreak("samsungandmango", new HashSet<String>(){{add("mobile");add("samsung");add("sam");add("sung");add("man");add("mango");add("icecream");add("and");add("go");add("i");add("like");add("ice");add("cream");}}));
		System.out.println(wordBreak("samsungandmangok", new HashSet<String>(){{add("mobile");add("samsung");add("sam");add("sung");add("man");add("mango");add("icecream");add("and");add("go");add("i");add("like");add("ice");add("cream");}}));
		System.out.println(wordBreak("leetcode", new HashSet<String>(){{add("leet");add("code");add("programcree");add("program");add("creek");}}));
		System.out.println(wordBreak("programcreek", new HashSet<String>(){{add("leet");add("code");add("programcree");add("program");add("creek");}}));
		System.out.println(wordBreak("lesscode", new HashSet<String>(){{add("leet");add("code");add("programcree");add("program");add("creek");}}));
		System.out.println(wordBreak("leetcode", new HashSet<String>(){{add("leet");add("code");add("leetcode");}}));
		System.out.println(wordBreak("goalspecial", new HashSet<String>(){{add("go");add("goal");add("goals");add("special");}}));
		System.out.println(wordBreak("succulence", new HashSet<String>() {{add("give");add("me");add("succ");add("u");add("like");add("lence");}}));
	}
	// not technically dp because it is faster than dp
	public static List<String> wordBreak(String word, Set<String> dict) {
		if(word.isEmpty())
			return new ArrayList<String>(0);
		Trie trie = new Trie();
		for(String str : dict)
			trie.put(str);
		List<String> results = new ArrayList<>();
		List<StringBuilder>[] dp = new List[word.length()];
		char[] c = word.toCharArray();
		getDP(c, 0, trie, dp);
		for(StringBuilder sb : (List<StringBuilder>)dp[0])
			results.add(sb.toString());
		return results;
	}
	public static List<StringBuilder> getDP(char[] c, int start, Trie trie, List<StringBuilder>[] dp) {
		List<Integer> ends = trie.getLegalEnds(c, start);
		dp[start] = new ArrayList<StringBuilder>();
		for(int end : ends)
			if(end == c.length - 1)
				dp[start].add(new StringBuilder().append(c, start, end - start + 1));
			else {
				if(dp[end + 1] == null)
					dp[end + 1] = getDP(c, end + 1, trie, dp);
				for(StringBuilder sb : (List<StringBuilder>)dp[end + 1])
					dp[start].add(new StringBuilder().append(c, start, end - start + 1).append(" ").append(sb));
			}
		return dp[start];
	}
	static class Trie {
		class Node {
			boolean exists = false;
			Node[] next = new Node[26];
		}
		Node root = new Node();
		public void put(String word) {
			put(word, root, 0);
		}
		public Node put(String word, Node root, int p) {
			if(root == null)
				root = new Node();
			if(p == word.length()) {
				root.exists = true;
				return root;
			}
			root.next[word.charAt(p) - 'a'] = put(word, root.next[word.charAt(p) - 'a'], p + 1);
			return root;
		}
		public List<Integer> getLegalEnds(char[] c, int start) {
			List<Integer> result = new ArrayList<>();
			get(c, root, result, start);
			return result;
		}
		public void get(char[] c, Node root, List<Integer> res, int pos) {
			if(root == null)
				return;
			if(root.exists)
				res.add(pos - 1);
			if(pos == c.length)
				return;
			get(c, root.next[c[pos] - 'a'], res, pos + 1);
		}
	}
}
