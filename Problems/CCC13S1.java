package Problems;

import java.util.Arrays;
import java.util.Scanner;

public class CCC13S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.nextLine();

        int p = Integer.parseInt(n) +1;

        while(true){
            if(!checkDup(Integer.toString(p))){
                System.out.println(p);
                break;
            }else{
                p++;
            }
        }


    }

    private static boolean checkDup(String a){
        char[] b = a.toCharArray();
        Arrays.sort(b);
        for (int i = 0; i < b.length-1; i++) {
            if(b[i] == b[i+1]){
                return true;
            }
        }
        return false;
    }
}
