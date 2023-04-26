package Problems.TriwayFinal;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] frequencyArray = new int[11];
        for (int i = 0; i < 100; i++) {
            frequencyArray[sc.nextInt()] ++;
        }
        for (int i = 0; i < frequencyArray.length; i++) {
            if(frequencyArray[i] % 2 == 0){
                System.out.println("The number " + i +  "has an even frequency");
            }
        }

    }
}
