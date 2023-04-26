package Problems.DmoJ;

import java.util.*;
import java.io.*;

/**
 * problem: MWC15C2P5 date: Sat Nov 20 2021
 */
public class MWC15C2P5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), K = readInt(), J = readInt();
        long[][] da = new long[3][N + 1];

        for (int i = 0; i < J; i++) {
            int x = readInt() - 1, X = readInt() - 1;
            long I = readLong();
            int t = readInt() - 1;

            da[t][x] += I;
            da[t][X + 1] -= I;
        }

        for (int i = 0; i < 3; i++) {
            // System.out.println("----");
            // System.out.println(Arrays.toString(da[i]));
            // System.out.println("----");
            long counter = 0;
            counter += da[i][0] < K ? 1 : 0;
            for (int j = 1; j < N; j++) {
                da[i][j] = da[i][j] + da[i][j - 1];
                counter += da[i][j] < K ? 1 : 0;
            }
            System.out.println(counter);
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