package Problems.DmoJ;

import java.util.*;
import java.io.*;

public class SAC22C1P1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
 
 
    public static void main(String[] args) throws IOException{
        int N = readInt();
        int M = readInt();

        char[][] grid = new char[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                grid[i][j] = readCharacter();
            }
        }

        int Q = readInt();
        for(int i = 0; i < Q; i++){
            int a = readInt();
            if(a == 1){
                for(int j = 0; j < grid.length - 1; j++){
                    for(int k = 0; k < grid[1].length; k++){
                        if(grid[j+1][k] == 'X'){
                            grid[j+1][k] = '.';
                            grid[j][k] = 'X';
                        }
                    }

                    for(int k = 0; k < grid[1].length; k++){
                        if(grid[j+1][k] == 'W'){
                            int q = k;
                            while(q >= 0 || grid[j+1][q] == '.'){
                                q -= 1;
                            }

                            if(q == 0 && grid[j][0] =='.'){
                                grid[j][0] = 'W';
                            }else{
                                grid[j+1][0] = 'W';
                            }
                        }
                    }
                }

            }else{
                for (char[] cs : grid) {
                    for(int j = 0; j < cs.length - 1; j ++){
                        System.out.print(cs[j] + " ");
                    }
                    System.out.println(cs[cs.length - 1]);
                }
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
