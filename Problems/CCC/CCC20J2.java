package Problems.CCC;

import java.util.Scanner;

public class CCC20J2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int N = sc.nextInt();
        int R = sc.nextInt();
        int day = 0;
        int infected = N;
        int oldInfected = N;
        while(infected <= P){
            day++;
            infected += oldInfected * R;
            oldInfected *= R;
        }


        System.out.println(day);
    }

}
