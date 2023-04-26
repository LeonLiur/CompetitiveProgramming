package Problems.DmoJ;

import java.util.Scanner;

public class OLYSUMMER1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            int sum = 0;
            for (int j = 0; j < s.length(); j++) {
                sum += Integer.parseInt(Character.toString(s.charAt(j)));
            }
            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}
