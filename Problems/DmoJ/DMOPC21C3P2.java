package Problems.DmoJ;

import java.util.*;
import java.io.*;
public class DMOPC21C3P2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    static int MM = 5000005;
 
 
    public static void main(String[] args) throws IOException{
        int N = readInt();
        int counter = 0;
        int[] a = new int[N];
        boolean[] flags = new boolean[MM];

        for(int i = 0; i < N; i++){
            a[i] = readInt();
        }

        Arrays.sort(a);

        for(int i = 0; i < N; i++){
            int val = a[i];
            if(!flags[val]){
                counter++;
                for(int j = val; j < MM; j += val){
                    flags[j] = true;
                }
            }
        }

        System.out.println(counter);
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