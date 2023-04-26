package AlgorithmSunday.week1;

import java.util.Scanner;

public class PalindromeProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(checkPal(n));
    }

    private static boolean checkPal(int toCheck) {
        String f = Integer.toString(toCheck);
        int n = f.length();

        for (int i = 1; i < n / 2; i++) {
            if (toCheck % Math.pow(10, i) == toCheck % Math.pow(10, n - i)) {
                return false;
            }
        }
        return true;
    }
}
