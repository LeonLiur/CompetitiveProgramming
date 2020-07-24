package AlgorithmSunday.week4.hw;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CCC13S2 {
    static int max_weight = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        max_weight = sc.nextInt();
        int n = sc.nextInt();
        Queue<Integer> myQ = new LinkedList<>();
        int counter = 0;

        for (int i = 0; i < n; i++) {
            myQ.add(sc.nextInt());
            if(myQ.size() > 4){
                myQ.remove();
            }

            if(legalSum(myQ)){
                counter++;
            }else{
                break;
            }
        }
        System.out.println(counter);

    }

    private static boolean legalSum(Queue<Integer> queue){
        int sum = 0;
        for (Integer x:queue
             ) {
            sum += x;
        }

        return sum <= max_weight;
    }
}
