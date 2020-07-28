package Problems.CCC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CCC18S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        int[][] chart = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                chart[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean unfixed = false;

        while (true) {
            chart = rotate90(chart);

            for (int i = 0; i < n; i++) {
                int[] x = chart[i];
                int[] xSorted = new int[n];
                System.arraycopy(x, 0, xSorted, 0, n);
                Arrays.sort(xSorted);

                int[] m = new int[n];
                for (int j = 0; j < n; j++) {
                    m[j] = chart[j][0];
                }

                int[] mSorted = new int[n];
                System.arraycopy(m, 0, mSorted, 0, n);
                Arrays.sort(mSorted);

//                System.out.println("x: ");
//                for (int a:x
//                     ) {
//                    System.out.print(a + " ");
//                }
//                System.out.println("\n-----");
//
//                System.out.println("xS: ");
//                for (int a:xSorted
//                ) {
//                    System.out.print(a + " ");
//                }
//                System.out.println("\n-----");
//
//                System.out.println("m: ");
//                for (int a:m
//                ) {
//                    System.out.print(a + " ");
//                }
//                System.out.println("\n-----");
//
//                System.out.println("mS: ");
//                for (int a:mSorted
//                ) {
//                    System.out.print(a + " ");
//                }
//                System.out.println("\n-----");


                if (!Arrays.equals(xSorted, x)) {
                    unfixed = true;
                    break;
                } else if (!Arrays.equals(mSorted, m)) {
                    unfixed = true;
                    break;
                }
            }

            if (!unfixed) {
                for (int[] x : chart
                ) {
                    for (int y : x
                    ) {
                        System.out.print(y + " ");
                    }
                    System.out.println();
                }
                break;
            }
            unfixed = false;

        }
    }

    private static int[][] rotate90(int[][] src) {
        int n = src.length;
        int[][] dest = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dest[j][n - i - 1] = src[i][j];
            }
        }
        return dest;
    }
}
