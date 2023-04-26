package Problems.DmoJ;

import java.util.*;
import java.io.*;

public class a2spooky4me {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
 
 
    public static void main(String[] args) throws IOException{
        Map<Long, Integer> wee = new HashMap();
        int N = readInt();
        long L = readLong();
        long S = readLong();

        int ind = 0;
        long[] mapping = new long[2 * N + 5];
        long[] da = new long[2 * N + 5];

        wee.put(0l, 0);
        mapping[0] = 0;
        ind ++;

        for(int i = 0; i < N; i++){
            long a = readInt();
            long b = readLong();
            long val = readLong();
            
            if(!wee.containsKey(a)){
                wee.put(a, ind);
                mapping[ind] = a;
                da[ind] += val;
                ind++;
            }
            if(!wee.containsKey(b)){
                wee.put(b, ind);
                mapping[ind] = b;
                da[ind + 1] -= val;
                ind++;
            }
        }

        for(int i = 0; i < 2 * N; i++){

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
