package week4;

import java.util.Scanner;

public class DMOPC14C2P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] massPrefix = new int[n];
        massPrefix[0] = sc.nextInt();

        for (int i = 1; i < n; i++) {
            massPrefix[i] = massPrefix[i-1] + sc.nextInt();
        }

        int q = sc.nextInt();
        int[][] queries = new int[q][2];

        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a>0)
                System.out.println(massPrefix[b] - massPrefix[a-1]);
            else
                System.out.println(massPrefix[b]);
        }

    }
}
