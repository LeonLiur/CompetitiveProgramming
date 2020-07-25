package Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class CCC15S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> integerStack = new Stack<>();

        int sum = 0;

        for (int i = 0; i < k; i++) {
            int current = Integer.parseInt(br.readLine());
            if (current == 0) {
                sum -= integerStack.pop();
            } else {
                integerStack.push(current);
                sum += current;
            }
        }

        System.out.println(sum);


    }
}
