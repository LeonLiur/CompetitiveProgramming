package Olympiads.Class0731;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Stack1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int M = sc.nextInt();

        Deque<String> deq = new LinkedList<String>();

        for (int i = 0; i < T; i++) {
            String name = sc.next();
            String status = sc.next();

            if(status.equalsIgnoreCase("in")){
                deq.addLast(name);
            }else if(status.equalsIgnoreCase("out") && M > 0){
                if(deq.getFirst().equalsIgnoreCase(name)){
                    M -= 1;
                    deq.removeFirst();
                }else if(deq.getLast().equalsIgnoreCase(name)){
                    deq.removeLast();
                }
            }
        }

        for (String s : deq) {
            if (!s.equalsIgnoreCase("")) {
                System.out.println(s);
            }
        }
    }
}
