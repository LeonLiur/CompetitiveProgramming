package Olympiads.Class0731;

import java.util.Scanner;

public class CPC21C1P1 {
    public static void main(String[] args) {
        int T;
        double A, B;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            A = sc.nextDouble();
            B = sc.nextDouble();
            double res = A/B;
            String restring = Double.toString(res);
            restring = restring.substring(restring.indexOf(".")+1);
            if (B*Math.pow(10, 9) % 1 == 0){
                System.out.println(restring.length());
            }else{
                System.out.println(-1);
            }
        }
    }

}
