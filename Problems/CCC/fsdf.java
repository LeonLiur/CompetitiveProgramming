package Problems.CCC;

import java.util.*;
import java.io.*;

public class fsdf{  

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

    static int N, M, P, Q;
    static Graph g;
    static boolean[] visited;

    static class Graph{
        int E;
        int V;
        ArrayList<Integer>[] adj;

        public Graph(int E, int V){
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
        int M = readInt();
        int s = readInt();
        int d = readInt();

        g = new Graph(N, M);
        for(int i = 0; i < M; i++){
            int a = readInt();
            int b = readInt();

            g.addEdge(a, b);
            g.addEdge(b, a);
        }
        
        dfs(s);

        if(visited[d]){
            System.out.println("GO SHAHIR");
        }else{
            System.out.println("NO SHAHIR");
        }
	}
    
    private static void dfs(int cur){
        visited[cur] = true;
        for(int x : g.adj[cur]){
            if(!visited[x]){
                dfs(x);
            }
        }
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