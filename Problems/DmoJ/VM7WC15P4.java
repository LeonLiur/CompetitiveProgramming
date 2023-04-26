package Problems.DmoJ;

import java.io.*;
import java.util.*;

public class VM7WC15P4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    static int V;
    static int E;
    static int[] costs;
    static boolean[] visited;
    static LinkedList<Integer[]>[] graph;

    static class Graph{
        Graph(){
            graph = new LinkedList[V];
            for(int i = 0; i < V; i++){
                graph[i] = new LinkedList<>();
            }
        }
        
        void addEdge(int s, int d, int cost){
            Integer[] temp = new Integer[2];
            temp[0] = d;
            temp[1] = cost;
            graph[s].addFirst(temp);
            temp[0] = s;
            graph[d].addFirst(temp);
        }
    }
 
    public static void main(String[] args) throws IOException{
        int V = readInt();
        int E = readInt();
        
        // edges = new Edge[E];
        // for(int i = 0; i < E; i++){
        //     edges[i] = new Edge(readInt(), readInt(), readInt());
        // }

        dijkstra(0);
    }

    private static void dijkstra(int start){
        costs[start] = 0;

        // for(int i =)
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
