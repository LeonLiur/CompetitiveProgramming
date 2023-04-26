package Problems.CCC;

import java.util.*;
import java.io.*;

public class CCC13S4{  

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

    static int N, M, P, Q;
    static Graph g;
    static boolean[] visited;

    static class Graph{
        long E;
        int V;
        ArrayList<Integer>[] adj;

        public Graph(long E, int V){
            this.E = E;
            this.V = V;
            adj = new ArrayList[V + 1];
            for(int i = 0; i < V + 1; i++){
                adj[i] = new ArrayList<Integer>();
            }
        }

        public void addEdge(int s, int d){
            adj[s].add(d);
        }
    }

	public static void main(String[] args) throws IOException{
        int N = readInt();
        long M = readInt();

        g = new Graph(M, N);
        for(int i = 0; i < M; i++){
            int a = readInt();
            int b = readInt();

            g.addEdge(a, b);
        }
        
        int p = readInt();
        int q = readInt();
        visited = new boolean[N+1];
        boolean a = dfs(p, q);
        visited = new boolean[N+1];
        boolean b = dfs(q, p);


        if(a){
            System.out.println("yes");
        }else if (b){
            System.out.println("no");
        }else{
            System.out.println("unknown");
        }
	}
    
    private static boolean dfs(int cur, int tar){
        boolean res = false;
        if(cur == tar)    return true;
        visited[cur] = true;
        for(int x : g.adj[cur]){
            if(!visited[x]){
                res = res || dfs(x, tar);
            }
        }
        return res;
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