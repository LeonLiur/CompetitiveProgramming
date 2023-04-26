package Triway.SeriousTriway.DP;

// DPA: first problem of DP     September 12, 2021
// https://dmoj.ca/problem/dpa
// Example problem of top-down approach of Dynamic Programming

import java.util.Arrays;
import java.util.Scanner;

public class dpa {

    static int[] dp;
    static int[] arr = new int[100001];
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n + 1];
        for (int i = 1; i < n+1; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.fill(dp, -1);
        System.out.println(dpr(1, n));
    }

    private static int dpr(int i, int target){
        if(i == target){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int cost = Math.abs(arr[i] - arr[i+1]) + dpr(i+1, target);
        if (i+2 <= target){
            cost = Math.min(cost, Math.abs(arr[i] - arr[i+2]) + dpr(i+2, target));
        }
        dp[i] = cost;
        return cost;
    }
}