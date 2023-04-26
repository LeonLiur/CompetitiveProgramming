package Problems.CCC;

import java.util.*;
import java.io.*;

/**
 * problem: Acyclic directed Graph date: Sat Nov 20 2021
 */
public class CCC07S4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    static class Graph {
        static ArrayList<Integer>[] adjList;
        static int[] dp;

        int V;

        Graph(int V) {
            this.V = V;
            dp = new int[V + 1];
            adjList = new ArrayList[V + 1];
            for(int i = 0; i < V + 1; i++){
                adjList[i] = new ArrayList<Integer>();
            }
            dp[1] = 1;
        }

        void addEdge(int src, int dest) {
            adjList[src].add(dest);
        }

        int dfs(int cur) {
            if(cur == 1){
                return 1;
            }

            int sum = 0;
            for (int x : adjList[cur]) {
                if(dp[x] != 0){
                    sum += dp[x];
                    continue;
                }
                sum += dp[x] = dfs(x);
            }

            return sum;
        }

    }

    public static void main(String[] args) throws IOException{
        int v = readInt();

        Graph graph = new Graph(v);

        int s = readInt();
        int d = readInt();

        while (s != 0 && d != 0) {
            graph.addEdge(d, s);

            s = readInt();
            d = readInt();
        }

        System.out.println(graph.dfs(v));
        // System.out.println(Arrays.toString(Graph.dp));
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }

    
}
