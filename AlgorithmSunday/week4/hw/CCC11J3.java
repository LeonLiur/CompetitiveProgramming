package week4.hw;

import java.util.Scanner;

public class CCC11J3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int buffer = 0;
        int counter = 2;

        do {
            buffer = a - b;
            a = b;
            b = buffer;
            counter++;
        } while (b <= a && b >= 0);
        System.out.println(counter);
    }
}