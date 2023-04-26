package Problems.DmoJ;

import java.io.*;
import java.util.*;

public class Binary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            Long a = sc.nextLong();
            String s = Long.toBinaryString(a);
            
            int counter = 0;

            for(int j = 0; j < (s.length() % 4 == 0? 0 : 4 - s.length()%4); j++){
                System.out.print("0");
                counter = j + 1;
            }
            
            for(int j = 0; j < s.length(); j++){
                System.out.print(s.charAt(j));
                counter ++;
                if(counter == 4){
                    System.out.print(" ");
                    counter = 0;
                }
            }
            System.out.println();
        }
    }
    
}