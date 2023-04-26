package Problems.DmoJ;

import java.util.Arrays;
import java.util.Scanner;

public class OLYSUMMER4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();
        final int N = sc.nextInt();
        int[][] city = new int[H][W];
        for (int i = 0; i < H; i++) {
            int[] xd = new int[W];
            for (int j = 0; j < W; j++) {
                xd[j] = sc.nextInt();
            }
            city[i] = xd;
        }

        int minimal = Integer.MAX_VALUE;

        for (int i = 0; i < H-N + 1; i++) {
            for (int j = 0; j < W-N + 1; j++) {

                int[] q = new int[N*N];
                for (int k = 0; k < N; k++) {
                    System.arraycopy(city[i + k], j, q, N * k, N);
                }
//                System.out.println("i: " + i + " j: " + j + "diff: " + findDifference(q));
                minimal = Math.min(findDifference(q), minimal);
            }
        }
        System.out.println(minimal);
    }

    private static int findDifference(int[] a){
        Arrays.sort(a);
        return a[a.length-1] - a[0];
    }
}

