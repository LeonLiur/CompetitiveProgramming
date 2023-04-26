package Problems.DmoJ;

import java.util.*;
import java.io.*;
/**
 * problem: NCCC5S4
 * date: Wed Nov 17 2021
 */
public class NCCC5S4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
 
 
    public static void main(String[] args) throws IOException{
        long N;
        int K;
        N = readLong();
        K = readInt();

        long[] onesList = new long[K];

        for(int i = 0; i < K; i++){
            onesList[i] = readLong();
        }
        
        if(K >= 3){
            long sum = 0;

            sum += onesList[0] * (N - onesList[2] + 1);

            for(int i = 1; i < K - 2; i++){
                sum += (onesList[i] - onesList[i-1]) * (N - onesList[i+2] + 1);
            }

            System.out.println(sum);
        }else{
            System.out.println(0);
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