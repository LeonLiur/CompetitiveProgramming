package Problems.DmoJ;

import java.util.*;
import java.io.*;
/**
 * problem: 
 * date: Sat Nov 20 2021
 */
public class NCCC9S1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
 
 
    public static void main(String[] args) throws IOException{
        int t = readInt();
        for(int i = 0; i < t; i++){
            long a = readLong();
            long b = readLong();
            long c = readLong();
            
            if((a + 2 * b + 3 * c) % 2 == 0){
                if(a >= c){
                    if(b % 2 == 0 || c > 0){
                        System.out.println("YES");
                        continue;
                    }
                }
            }
            System.out.println("NO");
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