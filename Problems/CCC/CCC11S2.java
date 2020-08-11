package Problems.CCC;

import java.util.Scanner;

public class CCC11S2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            A[i] = sc.next().charAt(0);
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += (A[i] == A[n + i]) ? 1 : 0;
        }

        System.out.println(sum);
    }
}
