package week1;

import java.util.Scanner;

public class ClockProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int f = sc.nextInt();
        int e = f / 720;
        int d = f % 720;
        if (d > 34) {
            System.out.println(e * 30 + 1);
            System.exit(0);
        }
        if (d > 71) {
            System.out.println(e * 30 + 2);
            System.exit(0);

        }
        if (d > 83) {
            System.out.println(e * 30 + 3);
            System.exit(0);

        }
        if (d > 95) {
            System.out.println(e * 30 + 4);
            System.exit(0);

        }
        if (d > 107) {
            System.out.println(e * 30 + 5);
            System.exit(0);

        }
        if (d > 119) {
            System.out.println(e * 30 + 7);
            System.exit(0);

        }
        if (d > 142) {
            System.out.println(e * 30 + 8);
            System.exit(0);

        }
        if (d > 2 * 60 + 34) {
            System.out.println(e * 30 + 10);
            System.exit(0);

        }
        if (d > 2 * 60 + 46) {
            System.out.println(e * 30 + 11);
            System.exit(0);

        }
        if (d > 2 * 60 + 58) {
            System.out.println(e * 30 + 12);
            System.exit(0);

        }
        if (d > 201) {
            System.out.println(e * 30 + 13);
            System.exit(0);

        }
        if (d > 213) {
            System.out.println(e * 30 + 14);
            System.exit(0);

        }
        if (d > 225) {
            System.out.println(e * 30 + 15);
            System.exit(0);

        }
        if (d > 260) {
            System.out.println(e * 30 + 16);
            System.exit(0);

        }
        if (d > 272) {
            System.out.println(e * 30 + 17);
            System.exit(0);

        }
        if (d > 284) {
            System.out.println(e * 30 + 18);
            System.exit(0);

        }
        if (d > 296) {
            System.out.println(e * 30 + 19);
            System.exit(0);

        }
        if (d > 331) {
            System.out.println(e * 30 + 20);
            System.exit(0);

        }
        if (d > 343) {
            System.out.println(e * 30 + 21);
            System.exit(0);
        }
        if (d > 355) {
            System.out.println(e * 30 + 22);
            System.exit(0);

        }
        if (d > 390) {
            System.out.println(e * 30 + 23);
            System.exit(0);

        }
        if (d > 402) {
            System.out.println(e * 30 + 24);
            System.exit(0);

        }
        if (d > 414) {
            System.out.println(e * 30 + 25);
            System.exit(0);

        }
        if (d > 461) {
            System.out.println(e * 30 + 26);
            System.exit(0);

        }
        if (d > 520) {
            System.out.println(e * 30 + 27);
            System.exit(0);

        }
        if (d > 532) {
            System.out.println(e * 30 + 28);
            System.exit(0);

        }
        if (d > 591) {
            System.out.println(e * 30 + 29);
            System.exit(0);

        }
        if (d > 671) {
            System.out.println(e * 30 + 30);
            System.exit(0);

        }
    }
}
