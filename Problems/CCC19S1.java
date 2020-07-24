package Problems;

import java.util.*;

public class CCC19S1{
// 1 2
// 3 4

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        String x = sc.next();

        for (Character character : x.toCharArray()) {
            if(!stack.empty()&&character == stack.get(0)){
                stack.pop();
            }else{
                stack.push(character);
            }
        }
        
        if(stack.size() == 2){
            System.out.println("4 3\n2 1");
        }else if(!stack.empty()&&stack.peek() == 'H'){
            System.out.println("3 4\n1 2");
        }else if(!stack.empty()&&stack.peek() == 'V'){
            System.out.println("2 1\n4 3");
        }else{
            System.out.println("1 2\n3 4");
        }


        sc.close();
    }
}