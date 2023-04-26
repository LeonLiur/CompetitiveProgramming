package Problems.TriwayFinal;

import java.util.Arrays;
import java.util.Scanner;

class Task9{
    public static void main(String[] args) {
        int[] sumArray = new int[100];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 100; i++) {
            int sum = 0;
            String number = sc.next();
            for (char x:number.toCharArray()
                 ) {
                sum += Integer.parseInt(Character.toString(x));
            }
            sumArray[i] = sum;
        }

        Arrays.sort(sumArray);
        System.out.println(sumArray[sumArray.length-1]);
    }
}