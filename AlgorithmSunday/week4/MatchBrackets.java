package week4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class MatchBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Stack<Character> myStack = new Stack<>();

        Map<Character, Character> myMap = new HashMap<>();
        myMap.put('{', '}');
        myMap.put('[', ']');
        myMap.put('(', ')');

        for (int i = 0; i < s.length(); i++) {
            if (myStack.empty()) {
                myStack.push(s.charAt(i));
            } else {
                if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                    myStack.push(s.charAt(i));
                } else {
                    if (s.charAt(i) != myMap.get(myStack.peek())) {
                        System.out.println("Not balanced.");
                        System.exit(0);
                    } else {
                        myStack.pop();
                    }
                }
            }
        }
        System.out.println("Balanced");
    }
}
