package Problems.CCC;

import java.util.Scanner;

public class CCC05S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            input = input.replace("-", "");
            for (int j = 0; j < 10; j++) {

                char x = input.toCharArray()[j];
                if (x > 58 && x < 80) {
                    input = input.replace(x, Integer.toString((x + 1) / 3 - 20).toCharArray()[0]);
                } else if (x == 'Z') {
                    input = input.replace('Z', '9');
                } else if (x > 80){
                    input = input.replace(x, Integer.toString((x)/3 - 20).toCharArray()[0]);
                } else if (x == 'P'){
                    input = input.replace('P', '7');
                }

                System.out.print(input.charAt(j));
                if(j == 2 || j == 5){
                    System.out.print('-');
                }
            }
            System.out.println();

        }
    }
}
