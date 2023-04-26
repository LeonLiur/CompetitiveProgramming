package Problems.DmoJ;

import java.io.*;
import java.util.*;

public class seed3 {
    public static void main(String[] args) throws IOException{
        int i = readInt();
        long n = readLong();
        int j = readInt();

        long arr[] = new long[i + 1];
        long da[] = new long[i + 2];

        for(int k = 0; k < j; k++){
            int l = readInt();
            int r = readInt();
            int x = readInt();
            da = update(da, l, r, x);
        }
        
        long counter = 0;

        for(int p = 1; p < i + 1; p++){
            arr[p] = p==0?da[p]:arr[p-1] + da[p];
            counter += arr[p] < n?1:0;
        }


        System.out.println(counter);
    }

    private static long[] update(long[] da, int l, int r, int x){
        da[l] += x;
        da[r + 1] -= x;

        return da;
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
