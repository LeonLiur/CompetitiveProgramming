package AlgorithmSunday.week0;

import java.util.Scanner;

public class CoinProblem {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        int v = sc.nextInt();

        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }

        int[][] cl = new int[v][2];
        for (int i = 0; i < v; i++) {
            int[] a = new int[2];
            for (int j = 0; j < 2; j++) {
                a[j] = sc.nextInt();
            }
            cl[i] = a;
        }

        for (int i = 0; i < v; i++) {
            int ttl = cl[i][0];
            int[] currencies = new int[cl[i][1]];

            System.arraycopy(d, 0, currencies, 0, currencies.length);

            int a = findMin(currencies, currencies.length, ttl);
            if (a != Integer.MAX_VALUE) {
                System.out.println(a);
            } else {
                System.out.println("-1");
            }
        }


    }

    private static int findMin(int[] values, int m, int V) {
        if (V == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            if (values[i] <= V) {
                int sub_res = findMin(values, m, V - values[i]);
                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
                    res = sub_res + 1;
            }
        }
        return res;
    }


}
