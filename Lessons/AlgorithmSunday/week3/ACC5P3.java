package AlgorithmSunday.week3;

import java.util.Scanner;
import java.util.Arrays;

public class ACC5P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        long[] myArray = new long[(int) n];
        long total = 0;

        for (int i = 0; i < n; i++) {
            long a = sc.nextInt();
            long b = sc.nextInt();
            myArray[i] = a-b;
            total += a;
        }

        Arrays.sort(myArray);

        for (int i = 0; i < k; i++) {
            total -= myArray[myArray.length - 1 - i];
        }

        System.out.println(total);
    }
}
