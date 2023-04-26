package Problems.MockCCC2021;

import java.util.Scanner;

public class DWITE10C1P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(calculate(Math.max(M, N), Math.min(M, N)));
        }
    }

    private static int calculate(int longer, int shorter){
        int times = 1;
        if (shorter == 0){
            return 0;
        }
        while (shorter/(int)Math.pow(2, times) >= 1) {
            times++;
        }
        times -= 1;
        return 1 + calculate(Math.max(shorter, longer - (int)Math.pow(2, times)), Math.min(shorter, longer - (int)Math.pow(2, times))) + calculate((int)Math.pow(2, times), shorter - (int) Math.pow(2, times));
    }
}
