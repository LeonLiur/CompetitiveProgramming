package week1;

import java.util.Scanner;

public class ParkingSpace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int counter = 0;
        char[] yesterday = sc.nextLine().toCharArray();
        char[] today = sc.nextLine().toCharArray();

        for (int i = 0; i < n; i++) {
            if (yesterday[i] == 'C' && today[i] == 'C') {
                counter++;
            }
        }
        System.out.println(counter);
    }

}
