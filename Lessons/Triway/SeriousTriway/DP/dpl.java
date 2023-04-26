//package Triway.SeriousTriway.DP;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//public class dpl {
//    public static long memo[][] = new long[3005][3005];
//    public static long a[] = new long[3005];
//
//    public static long fun(int l, int r)
//    {
//        if (l == r)
//            return a[l];
//        if (memo[l][r] != -1)
//            return memo[l][r];
//        memo[l][r] = Math.max(-fun(l, r-1) + a[r], -fun(l+1, r) + a[l]);
//        return memo[l][r];
//    }
//
//    public static void main(String[] args) throws IOException
//    {
//        for (int i = 0; i < 3005; i++)
//            Arrays.fill(memo[i], -1);
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(in.readLine());
//
//        String[] tmp = in.readLine().split(" ");
//        for (int i = 1; i <= N; i++)
//            a[i] = Integer.parseInt(tmp[i-1]);
//        System.out.println(fun(1, N));
//    }
//}
//
////memo[left][right]
////memo[left][left] = a[left]
////memo[left][right] = max {
////    -memo[left+1][right] + a[left]
////    -memo[left][right-1] + a[right]
//}
