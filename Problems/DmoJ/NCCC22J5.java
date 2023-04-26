package Problems.DmoJ;

import java.util.*;
import java.io.*;
public class NCCC22J5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static class Node implements Comparable<Node>{
		int a, b;
		public Node(int a, int b){
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Node o) {
			return - this.b + o.b;
		}
	}

	public static void main(String[] args) throws IOException{
		int n = readInt();
		int m = readInt();
		if(m == 0){
			System.out.println(n);
			System.exit(0);
		}
		ArrayList<Integer>[] adj;
		adj = new ArrayList[n];
		Node[] v = new Node[n];
		boolean[] excluded = new boolean[n];

		for(int i = 0; i < n; i++){
			adj[i] = new ArrayList<Integer>();
			v[i] = new Node(i, 0);
		}

		for(int i = 0; i < m; i++){
			int a = readInt() - 1;
			int b = readInt() - 1;
			adj[a].add(b);
			adj[b].add(a);
			v[a].b += 1;
			v[b].b += 1;
		}

		Arrays.sort(v);

		int max = 0;

		for(Node cur : v){
			int curNode = cur.a;
			if(!adj[curNode].isEmpty()){
				// System.out.println("current node: " + (curNode + 1));
				for(int x : adj[curNode]){
					// System.out.println("removing node " + (curNode + 1) + " from node " + (x + 1));
					adj[x].remove(Integer.valueOf(curNode));
				}
				adj[curNode].clear();
				excluded[curNode] = true;
			}
			int count = 0;
			
			for (Node node : v) {
				if(excluded[node.a])	continue;
				if(adj[node.a].isEmpty()){
					count++;
				}
			}
			max = Math.max(max, count);
		}

		System.out.println(max);
	}

	

	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}