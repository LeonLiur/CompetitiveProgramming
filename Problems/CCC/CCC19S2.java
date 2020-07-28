package Problems.CCC;

import java.util.Scanner;

public class CCC19S2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, q;

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            q = sc.nextInt();
            for (int j = 3; j <= q; j++) {
                if (isPrime(j) && isPrime(2 * q - j)) {
                    System.out.println(j + " " + (2 * q - j));
                    break;
                }
            }
        }
    }

    private static boolean isPrime(double toTest) {
//        System.out.println(Math.sqrt(toTest));
        for (int i = 2; i < Math.sqrt(toTest) + 1; i++) {
            if (toTest % i == 0 && toTest != i) {
                return false;
            }
        }

        return true;
    }
}
