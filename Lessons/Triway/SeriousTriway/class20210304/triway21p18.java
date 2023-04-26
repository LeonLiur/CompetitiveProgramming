package Triway.SeriousTriway.class20210304;

import java.util.Scanner;

public class triway21p18 {
    static int max;
    static int min;
    static int guess;
    static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        max = 2000000000;
        min = 1;
        System.out.println((max+min)/2);
        recursion();
    }

    private static void recursion(){
        if(sc.next().equals("OK")){
            System.exit(0);
        }else if(sc.next().equals("FLOATS")){
            max = guess;
        }else{
            min = guess;
        }
        guess = (max+min)/2;
        System.out.println(guess);
        recursion();
    }


}
