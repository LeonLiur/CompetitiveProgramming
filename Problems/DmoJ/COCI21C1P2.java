package Problems.DmoJ;

import java.util.*;
import java.io.*;

public class COCI21C1P2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;


    static int[] psa;
    static int[][][] dpa;
    static int n, k;
 
 
    public static void main(String[] args) throws IOException{
        n = readInt();
        k = readInt();

        dpa = new int[350][350][350];
        psa = new int[n];
        String s = next();

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            psa[i] = i == 0?c == 'C'?1:0:c=='C'?psa[i-1] + 1: psa[i-1];
        }

        System.out.println(dp(0, n-1, 0)?"DA":"NE");
        // System.out.println(Arrays.toString(psa));
    }

    private static boolean dp(int l, int r, int m){
        int h;
        if(l == 0){
            h = psa[n - 1] - m - psa[r];
        }else{
            h = psa[n - 1] - m - (psa[r] - psa[l - 1]);
        }
        // System.out.println("Curent state: l: " + l + " || r: " + r + " || m: " + m + " || h: " + h);
        if(dpa[l][r][m] != 0)   return dpa[l][r][m] == 2;
        if(m >= k)  return false;
        if(h >= k)  return true;
        
        dpa[l][r][m] = (!dp(l+1, r, h) || !dp(l, r - 1, h))?2:1;
        return dpa[l][r][m]==2;
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
