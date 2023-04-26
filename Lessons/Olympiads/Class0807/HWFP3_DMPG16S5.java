package Olympiads.Class0807;

import java.util.Scanner;

public class HWFP3_DMPG16S5 {
    // Construct two arrays: sample
    // 5 5
    // 1 3 -8 -2 4 =====> DUPLICATING to make two duplicates of the array
    // To get subarray sum -> prefix sum array
    // for any subarray [L, R]      sum = psa[R] - psa[L-1]
    // maximize {psa[R] - psa[L-1]}     psa[R] - min {psa[L-1]  R-K < L <= R
    // Converting it to sliding window minimal
    // mono queue
    // index    1   2   3   4   5   6   7   8   9   10
    // a        1   3   -8  -2  4   1   3   -8  -2  4
    // psa      1   4   -4  -6  -2  -1  2   -6  -8  -4
    public static void main(String[] args) {
        int N,K;
        Scanner sc = new Scanner(System.in);
        long[] psa = new long[Integer.MAX_VALUE];
    }

}
