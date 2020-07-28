package Problems.CCC;

import java.util.Scanner;

public class CCC11S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int tCounter = 0;
        int sCounter = 0;

        for (int i = 0; i < n; i++) {
            String a = sc.nextLine().toLowerCase();
            for (char x : a.toCharArray()
                 ) {
                if(x == 's'){
                    sCounter++;
                }else if(x == 't'){
                    tCounter++;
                }
            }
        }

        System.out.println(tCounter>sCounter?"English":"French");

    }
}
