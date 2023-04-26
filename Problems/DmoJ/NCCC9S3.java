package Problems.DmoJ;

import java.util.*;
import java.io.*;
public class NCCC9S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
 
 
    public static void main(String[] args) throws IOException{
        int N = readInt();
        String s = next();

        int counterIU = 0;

        for(int i = 1; i < 2*N; i++){
            if(s.charAt(i) == 'U' && s.charAt(i-1) == 'I'){
                counterIU += 1;
            }
        }

        System.out.println(N - counterIU);
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