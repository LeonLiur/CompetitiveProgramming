package Problems.DmoJ;

import java.util.Scanner;

public class OLYSUMMER2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int longest = 0;
        int index1 = s.indexOf("A");
        int index2 = s.lastIndexOf("Z");
        longest = index2-index1 + 1;

        System.out.println(longest);

    }
}
