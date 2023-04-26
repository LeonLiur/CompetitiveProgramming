package Triway.SeriousTriway.DP;

import java.util.Scanner;

public class dpe {
    static int N;
    static long C;
    static int[] w = new int[105];
    static int[] v = new int[105];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        C = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        long[][] table = new long[2][C+1];
        
        for (int i = 0; i <= N ; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j <= C; j++) {
                   if (w[i] <= j)
                        table[0][j] = Math.max(v[i] + table[1][j - w[i]], table[1][j]);
                    else
                        table[0][j] = table[1][j];
                }
            }else{
                for (int j = 0; j <= C; j++) {
                    if (w[i] <= j)
                        table[1][j] = Math.max(v[i] + table[0][j - w[i]], table[0][j]);
                    else
                        table[1][j] = table[0][j];
                }
            }
        }

        System.out.println(N % 2 == 0?table[0][C]:table[1][C]);
    }

}
