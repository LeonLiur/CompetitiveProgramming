package Triway.SeriousTriway.DP;

import java.util.Scanner;

public class dpc{
    static int[][] schedule;
    static int[][] dp;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        schedule = new int[100005][3];
        dp = new int[100005][4];


        for (int i = 0; i < N; i++) {
            schedule[i][0] = sc.nextInt();
            schedule[i][1] = sc.nextInt();
            schedule[i][2] = sc.nextInt();

            dp[i][0] = -1;
            dp[i][1] = -1;
            dp[i][2] = -1;
            dp[i][3] = -1;
        }

        int maxVal = dpr(0, 3);
        System.out.println(maxVal);
    }

    private static int dpr(int cur, int prev){
        if(cur == N) return 0;

        if(dp[cur][prev] != -1) return dp[cur][prev];

        int max = 0;

        if(prev == 3){
            max = Math.max(max, schedule[cur][0] + dpr(cur+1,0));
            max = Math.max(max, schedule[cur][1] + dpr(cur+1,1));
            max = Math.max(max, schedule[cur][2] + dpr(cur+1,2));
        }else if(prev == 0){
            max = Math.max(max, schedule[cur][1] + dpr(cur+1, 1));
            max = Math.max(max, schedule[cur][2] + dpr(cur+1, 2));
        }else if(prev == 1){
            max = Math.max(max, schedule[cur][2] + dpr(cur+1, 2));
            max = Math.max(max, schedule[cur][0] + dpr(cur+1, 0));
        }else if(prev == 2){
            max = Math.max(max, schedule[cur][1] + dpr(cur+1, 1));
            max = Math.max(max, schedule[cur][0] + dpr(cur+1, 0));
        }

        return dp[cur][prev] = max;
    }

}
