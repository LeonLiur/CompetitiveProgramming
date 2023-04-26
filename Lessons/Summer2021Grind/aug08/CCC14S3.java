package Summer2021.aug08;

import java.util.Scanner;
import java.util.Stack;

public class CCC14S3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            boolean outputN = false;
            Stack<Integer> sideStack = new Stack<>();
            Stack<Integer> topStack = new Stack<>();
            boolean found = false;
            int N = sc.nextInt();
            for (int j = 0; j < N; j++) {
                topStack.add(sc.nextInt());
            }
            for (int cur = 1; cur < N+1; cur++) {
//                System.out.println(topStack);
//                System.out.println(sideStack);
                found = false;
                if (!sideStack.isEmpty() && sideStack.peek() == cur) {
                    sideStack.pop();
                    found = true;
                } else if (!topStack.isEmpty() && topStack.peek() == cur) {
                    topStack.pop();
                    found = true;
                } else {
                    while (!topStack.isEmpty()) {
                        if (topStack.peek() == cur) {
                            topStack.pop();
                            found = true;
                            break;
                        } else {
                            sideStack.push(topStack.pop());
                        }
                    }
                }
                if (!found) {
                    System.out.println("N");
                    outputN = true;
                    break;
                }
            }
            if(!outputN){
                System.out.println("Y");
            }
        }
    }
}
