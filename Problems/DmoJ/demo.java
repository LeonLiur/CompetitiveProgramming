package Problems.DmoJ;

import java.util.*;
import java.io.*;
public class demo {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
 
    static int n, m;
    static int[][] adj;
 
    public static void main(String[] args) throws IOException{
        // n is the number of nodes
        // m is the number of edges
        n = readInt();
        m = readInt();
        adj = new int[n][n];

        for(int i = 0; i < m; i++){
            int start = readInt();
            int end = readInt();


            // filling the adjacency matrix with values
            adj[start][end] = 1;
            adj[end][start] = 1;
        }

        bfs(3);
    }

    // bfs method
    private static void bfs(int start){
        // initializing queue data structure
        Queue<Integer> q = new LinkedList<>();
        // initializing visited array
        boolean[] visited = new boolean[n];

        // adding the starting point
        q.add(start);

        // we want to keep visiting the queue until there is nothing left in the queue to visit
        while(!q.isEmpty()){
            // set a variable for the current node that we're at (popping the queue)
            int cur = q.poll();

            // if a node is already visited, we can just skip it and visit the next thing in the queue, the
            // 'continue' keyword lets you skip this iteration of the while-loop
            if(visited[cur]){
                continue;
            }

            // set the visited value of the current node to true
            visited[cur] = true;

            System.out.println("currently visiting: " + cur);

            for(int i = 0; i < n; i++){
                // add another node to the queue if that node is connected to the current node
                if(adj[cur][i] == 1){
                    q.add(i);
                    System.out.println("added " + i);
                }
            }
        }

        // email: wjim2005@gmail.com
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