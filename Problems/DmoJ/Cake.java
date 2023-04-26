package Problems.DmoJ;

import java.util.*;
import java.io.*;

/**
 * problem: the cake is a dessert date: Fri Nov 19 2021
 */
public class Cake {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N, M, K;
        N = readInt();
        M = readInt();
        K = readInt();

        long[][] grid = new long[N + 1][M + 1];

        for (int i = 0; i < K; i++) {
            int x1 = readInt() - 1;
            int y1 = readInt() - 1;
            int x2 = readInt() - 1;
            int y2 = readInt() - 1;

            grid[x1][y2 + 1] -= 1;
            grid[x2 + 1][y1] -= 1;
            grid[x1][y1] += 1;
            grid[x2 + 1][y2 + 1] += 1;
        }

        // for (int[] is : grid) {
        //     System.out.println(Arrays.toString(is));
        // }
        // System.out.println("\n");

        long[][] finalArr = new long[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 && j == 0) {
                    finalArr[i][j] = grid[i][j];
                } else if (i == 0) {
                    finalArr[i][j] = finalArr[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    finalArr[i][j] = finalArr[i - 1][j] + grid[i][j];
                } else {
                    finalArr[i][j] = finalArr[i - 1][j] + finalArr[i][j - 1] - finalArr[i - 1][j - 1] + grid[i][j];
                    // System.out.println(finalArr[i - 1][j] + " + " + finalArr[i][j - 1] + " - " + finalArr[i - 1][j - 1] + " + " + grid[i][j] + " = " + finalArr[i][j]);
                }
            }
        }

        // for (int[] is : finalArr) {
        //     System.out.println(Arrays.toString(is));
        // }

        long[][] finalPSA = new long[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 && j == 0) {
                    finalPSA[i][j] = finalArr[0][0];
                } else if (i == 0) {
                    finalPSA[i][j] = finalPSA[i][j - 1] + finalArr[i][j];
                } else if (j == 0) {
                    finalPSA[i][j] = finalPSA[i - 1][j] + finalArr[i][j];
                } else {
                    finalPSA[i][j] = finalPSA[i - 1][j] + finalPSA[i][j - 1] - finalPSA[i - 1][j - 1] + finalArr[i][j];
                }
            }
        }

        int Q = readInt();

        for (int i = 0; i < Q; i++) {
            long sum = 0;
            int x1 = readInt() - 1;
            int y1 = readInt() - 1;
            int x2 = readInt() - 1;
            int y2 = readInt() - 1;

            if (x1 == 0 && y1 == 0) {
                sum = finalPSA[x2][y2];
            } else if (x1 == 0) {
                sum = finalPSA[x2][y2] - finalPSA[x2][y1 - 1];
            } else if (y1 == 0) {
                sum = finalPSA[x2][y2] - finalPSA[x1 - 1][y2];
            } else {
                sum = finalPSA[x2][y2] - finalPSA[x1 - 1][y2] - finalPSA[x2][y1 - 1] + finalPSA[x1 - 1][y1 - 1];
            }

            System.out.println(sum);
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