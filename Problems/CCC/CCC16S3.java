package Problems.CCC;

import java.io.*;
import java.util.*;

public class CCC16S3 {
    static class Graph{
        int E, V;
        ArrayList<Integer>[] adjList;
        boolean[] valid;
        boolean[] phoList;
        int[] dist;
        int phoExample = -1;
        int maxDistance1 = -1;
        int maxDistance2 = -1;
        int maxDistanceIndex = -1;
        int maxDistanceIndex2 = -1;
        ArrayList<Integer> optimal;
        int optimalCount = 0;

        public Graph(int E, int V){
            this.E = E;
            this.V = V;
            adjList = new ArrayList[V];
            for(int i = 0; i < V; i++){
                adjList[i] = new ArrayList<Integer>();
            }
            valid = new boolean[V];
            phoList = new boolean[V];
            dist = new int[V];
            optimal = new ArrayList<Integer>();
        }

        public void addPho(int pho){
            phoList[pho] = true;
            phoExample = pho;
        }

        public void addEdge(int src, int dest){
            adjList[src].add(dest);
            adjList[dest].add(src);
        }


        private boolean prune(int cur, int par){
            boolean m = false;
            if(phoList[cur])    m = true;
            for(int x : adjList[cur])   if(x != par)    m = prune(x, cur) || m;
            
            return valid[cur] = m;
        }

        private void dfs(int cur, int par, int distance){
            dist[cur] = distance;
            maxDistance1 = Math.max(maxDistance1, distance);
            if(maxDistance1 == distance)    maxDistanceIndex = cur;
            for(int x : adjList[cur])   if(x!= par && valid[x]) dfs(x, cur, distance + 1);
        }

        private void dfs2(int cur, int par, int distance){
            dist[cur] = distance;
            maxDistance2 = Math.max(maxDistance2, distance);
            if(maxDistance2 == distance)    maxDistanceIndex2 = cur;
            
            for(int x : adjList[cur])   if(x!= par && valid[x]) dfs2(x, cur, distance + 1);
        }

        private boolean dfs3(int cur, int par, int tar){
            optimal.add(cur);
            if(phoList[cur])    optimalCount++;
            if(cur == tar)  return true;

            boolean m = false;

            for(int x : adjList[cur]){
                if(x != par && valid[x]){
                    m = dfs3(x, cur, tar) || m;
                }
            }

            if(m)   return true;
            optimal.remove(Integer.valueOf(cur));
            if(phoList[cur])    optimalCount--;
            return false;
        }

        private void clear(){
            dist = new int[V];
        }

        
    }
    public static void main(String[] args) throws IOException{
        int N, M, validCount = 0;
        N = readInt();
        M = readInt();
        Graph g = new Graph(N-1, N);
        for(int i = 0; i < M; i++)  g.addPho(readInt());
        for(int i = 0; i < N - 1; i++)  g.addEdge(readInt(), readInt());

        g.prune(g.phoExample, -1);

        g.dfs(g.phoExample, -1, 0);
        // System.out.println("EXAMPLE: " + g.phoExample);
        for(int i = 0; i < g.valid.length; i++) validCount+=g.valid[i]?1:0;

        g.clear();

        g.dfs2(g.maxDistanceIndex, -1, 0);

        g.dfs3(g.maxDistanceIndex, -1, g.maxDistanceIndex2);

        // System.out.println(g.optimal);



        System.out.println(validCount * 2 - (g.maxDistance2 + 2));
    }


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

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
