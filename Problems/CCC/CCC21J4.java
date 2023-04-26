package Problems.CCC;

import java.util.*;
import java.io.*;

public class CCC21J4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
 
 
    public static void main(String[] args) throws IOException{
        String s = next();
        int[] pfL = new int[6];
        int[] pfM = new int[6];
        int[] pfS = new int[6];

        if(s.charAt(0) == 'L'){
            pfL[1] = 1;
            pfM[1] = 0;
            pfS[1] = 0;
        }
        if(s.charAt(0) == 'M'){
            pfL[1] = 0;
            pfM[1] = 1;
            pfS[1] = 0;
        }
        if(s.charAt(0) == 'S'){
            pfL[1] = 0;
            pfM[1] = 0;
            pfS[1] = 1;
        }
        
        for(int i = 1; i < s.length();i++){
            if(s.charAt(i) == 'L'){
                pfL[i + 1] = pfL[i] + 1;
                pfM[i + 1] = pfM[i];
                pfS[i + 1] = pfS[i];
            }
            if(s.charAt(i) == 'M'){
                pfL[i + 1] = pfL[i];
                pfM[i + 1] = pfM[i] + 1;
                pfS[i + 1] = pfS[i];
            }
            if(s.charAt(i) == 'S'){
                pfL[i + 1] = pfL[i];
                pfM[i + 1] = pfM[i];
                pfS[i + 1] = pfS[i] + 1;
            }
        }
        
        int lEnd, mEnd;
        lEnd = pfL[s.length()];
        mEnd = lEnd + pfM[s.length()];

        System.out.println(pfM[lEnd] + pfS[lEnd] 
        + (pfL[mEnd] - pfL[lEnd]) + (pfS[mEnd] - pfS[lEnd]) 
        - Math.min(pfM[lEnd], (pfL[mEnd] - pfL[lEnd])));
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