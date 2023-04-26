package Triway.SeriousTriway.DP;

import java.util.Scanner;

public class dpd {
    static int N;
    static int C;
    static int[] w = new int[105];
    static int[] v = new int[105];
    static long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        C = sc.nextInt();
        dp = new long[N+1][C+1];
        for (int i = 1; i <= N; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
            for (int j = 1; j<= C; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(dpr(N, C));
    }

    private static long dpr(int n, int C){
        if(dp[n][C] != -1) return dp[n][C];
        if(n==0||C==0)  return 0;
        if(w[n] > C)    return dpr(n-1, C);

        return dp[n][C] = Math.max(dpr(n-1, C), v[n] + dpr(n-1, C - w[n]));
    }
}
