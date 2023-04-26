package Problems.CCC;

import java.util.*;
import java.io.*;

/**
 * problem: Acyclic directed Graph date: Wed Dec 1 2021
 */
public class CCC04S1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    static int[][] matrix = new int[1005][1005];
    static int c;

    public static void main(String[] args) throws IOException {
        c = readInt();
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = readInt();
            }
        }

        boolean[] recStack = new boolean[c];
        boolean[] visited = new boolean[c];


        for (int i = 0; i < c; i++) {
            if(dfs(i, visited, recStack)){
                System.out.println("NO");
                System.exit(0);
            }
        }

        System.out.println("YES");
    }

    private static boolean dfs(int i, boolean[] visited, boolean[] recStack) {

        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;

        for (int j = 0; j < c; j++){
            if(matrix[i][j] == 1){
                if (dfs(j, visited, recStack))
                    return true;
            }
        }

        recStack[i] = false;

        return false;
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