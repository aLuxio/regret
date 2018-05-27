package State.st2018;

import java.io.*;
import java.util.*;

public class Dinesh {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/State/st2018/data/sampleData/dinesh.dat"));
		for(int T = Integer.parseInt(file.nextLine()); T > 0; --T) {
			String[] nodes = file.nextLine().trim().split("\\s");
			Map<String, Set<Edge>> adj = new HashMap<>();
			for(int E = Integer.parseInt(file.nextLine()); E > 0; --E) {
				String[] s = file.nextLine().trim().split("\\s");
				adj.computeIfAbsent(s[0], x -> new HashSet<>()).add(new Edge(s[0], s[1], Integer.parseInt(s[2])));
				adj.computeIfAbsent(s[1], x -> new HashSet<>()).add(new Edge(s[1], s[0], Integer.parseInt(s[2])));
			}
			for(int Q = Integer.parseInt(file.nextLine()); Q > 0; --Q) {
				String[] s = file.nextLine().trim().split("\\s");
				System.out.println(s[0] + " to " + s[1] + ":" + find(adj, s[0], s[1]));
			}
		}
		file.close();
	}

	public static int find(Map<String, Set<Edge>> adj, String from, String dest) {
		ArrayDeque<Edge> s = new ArrayDeque<>(adj.get(from));
		HashSet<String> visited = new HashSet<>();
		int ans = Integer.MAX_VALUE;
		while(!s.isEmpty()) {
			Edge e = s.pop();
			visited.add(e.start);
			if(e.end.equals(dest))
				ans = Math.min(ans, e.w);
			else
				for(Edge edge : adj.get(e.end))
					if(!visited.contains(edge.start))
						s.add(new Edge(edge.start, edge.end, edge.w + e.w));
		}
		return ans;
	}

	static class Edge {
		String start, end;
		int w;

		public Edge(String start, String end, int w) {
			this.start = start;
			this.end = end;
			this.w = w;
		}
	}
}
