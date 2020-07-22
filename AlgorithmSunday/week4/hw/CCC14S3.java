package week4.hw;

import java.util.Scanner;
import java.util.Stack;

public class CCC14S3 {
    static Stack<Integer> topStack = new Stack<>();
    static Stack<Integer> branchStack = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int i = 0; i < tests; i++) {
            topStack = new Stack<>();
            branchStack = new Stack<>();
            int n = sc.nextInt();
            String toPrint = "Y";
            for (int j = 0; j < n; j++) {
                topStack.add(sc.nextInt());
            }
            int current = 1;
            while (current <= n){
                if(!currentFound(current)){
                    toPrint = "N";
                    break;
                }
                current ++;
            }
            System.out.println(toPrint);
        }
    }

    private static boolean currentFound(int toFind){
        if(branchStack.contains(toFind) && branchStack.peek()!= toFind){
            return false;
        }else if(branchStack.contains(toFind) && branchStack.peek() == toFind){
            branchStack.pop();
            return true;
        }else{
            while(topStack.peek() != toFind){
                branchStack.push(topStack.peek());
                topStack.pop();
            }

            topStack.pop();
            return true;
        }
    }
}
