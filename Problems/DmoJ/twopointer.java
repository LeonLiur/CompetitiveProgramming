package Problems.DmoJ;

import java.util.*;
import java.io.*;

public class twopointer {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        long sum = readLong();

        long[] arr = new long[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = readLong();
        }

        int x = 0;
        int y = arr.length-1;

        while(x < y){
            long temp = arr[x] + arr[y];
            if(temp < sum) x++;
            else if(temp > sum) y--;
            else if(temp == sum) System.out.println(x + " " + y);
            else System.out.println("IMPOSSIBLE");
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}