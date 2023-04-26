package Problems.TriwayFinal;

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] my2d = new char[7][7];
        for (int i = 0; i < 7; i++) {
            my2d[i] = sc.next().toCharArray();
        }
        System.out.println(my2d[5][5]);
    }
}
