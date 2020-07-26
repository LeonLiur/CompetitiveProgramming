package Problems;

import java.util.Scanner;

public class CCC12S1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 2; j < n; j++) {
                for (int k = 3; k < n; k++) {
                    if(i<j&&j<k){
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

}
