package Problems.CCC;

import java.util.Scanner;

public class CCC10S2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String[][] mapping = new String[k][2];
        for (int i = 0; i < k; i++) {
            String character = sc.next();
            String pattern = sc.next();
            mapping[i][0] = character;
            mapping[i][1] = pattern;
        }

        String text = sc.next();
        while (text.length() > 0) {
            for (String[] current : mapping
            ) {
                String curPattern = current[1];
                if (text.startsWith(curPattern)) {
                    text = text.replaceFirst(curPattern, "");
                    System.out.print(current[0]);
                    break;
                }
            }
        }
    }
}
