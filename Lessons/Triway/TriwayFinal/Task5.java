package Problems.TriwayFinal;

import java.util.Scanner;

public class Task5 {
    private final static String[] VOWELS = {"a", "e", "i", "o", "u"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.toLowerCase();
        String[] words = s.split(" ");
        int count = 0;
        String word7 = words[6];
        for (String x:VOWELS
             ) {
            while (word7.contains(x)){
                count++;
                word7 = word7.replaceFirst(x, "");
            }
        }

        System.out.println(count);
    }
}
