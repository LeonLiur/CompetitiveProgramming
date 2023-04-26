package Problems.DmoJ;

import java.util.*;
import java.io.*;

public class SAC22CC2P1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
 
 
    public static void main(String[] args) throws IOException{
        int A = readInt();
        int K = readInt();
        String[] schedule = new String[32];
        for(int i = 0; i < A; i++){
            int b = readInt();
            String s = next();
            schedule[b] = s;
        }

        int lastCheck = 0;
        for(int i = 0; i < K; i++){
            if(i == 0){
                if(schedule[i] == null){
                    continue;
                }else{
                    
                }
            }else{

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
