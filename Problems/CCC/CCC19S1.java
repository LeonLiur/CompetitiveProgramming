package Problems.CCC;

import java.util.*;

public class CCC19S1{
// 1 2
// 3 4

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String x = sc.next();

        int hCounter = 0;
        int vCounter = 0;

        for (Character character : x.toCharArray()) {
            if(character == 'H'){
                hCounter++;
            }else{
                vCounter++;
            }
        }
        hCounter %= 2;
        vCounter %= 2;

        if(hCounter == 1){
            if(vCounter == 1){
                System.out.println("4 3\n2 1");
            }else{
                System.out.println("3 4\n1 2");
            }
        }else{
            if(vCounter == 1){
                System.out.println("2 1\n4 3");
            }else{
                System.out.println("1 2\n3 4");
            }
        }

        sc.close();
    }
}
