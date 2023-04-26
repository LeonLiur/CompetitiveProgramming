package Problems.TriwayFinal;

import java.util.Scanner;
import java.util.Stack;

public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 100; i++) {
            stack.add(sc.nextInt());
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(stack.pop());
        }
    }
}
