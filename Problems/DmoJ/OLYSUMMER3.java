package Problems.DmoJ;

import java.util.Scanner;
import java.util.Stack;

public class OLYSUMMER3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Stack<Character> newStack = new Stack<>();
            String s = sc.next();
            String answer = "YES";
            for (int j = 0; j < s.length(); j++) {
//                System.out.println("current: " + s.charAt(j));
                if (!isStringInt(Character.toString(s.charAt(j)))) {
                    if (s.charAt(j) == '(') {
                        newStack.push('(');
                    } else {
                        if (newStack.isEmpty()) {
                            answer = "NO";
                            break;
                        } else {
                            newStack.pop();
                        }
                    }
                }
            }
            if(!answer.equalsIgnoreCase("NO") && !newStack.isEmpty()){
                answer = "NO";
            }

            System.out.println(answer);
        }
    }

    public static boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}