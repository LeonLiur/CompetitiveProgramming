package week2;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class CCC07J4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        boolean c = checkAnagram(a, b);

        if (c) {
            System.out.println("Is an anagram.");
        } else {
            System.out.println("Is not an anagram.");
        }
    }

    private static boolean checkAnagram(String a, String b) {
        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            char f = Character.forDigit((97+i),10);
            mapA.put(f, 0);
            mapB.put(f, 0);
        }

        a = a.replace(" ", "");
        b = b.replace(" ", "");

        char[] charArrA = a.toLowerCase().toCharArray();
        char[] charArrB = b.toLowerCase().toCharArray();

//        if(charArrA.length!=charArrB.length){
//            return false;
//        }
        for (char value : charArrA) {
            Character c = Character.forDigit(value, 10);
            Character d = Character.forDigit(value, 10);
            if (mapA.containsKey(c)) {
                mapA.replace(c, mapA.get(c) + 1);
            }
            if (mapB.containsKey(d)) {
                mapB.replace(d, mapB.get(d) + 1);
            }

        }
        System.out.println(mapA);
        System.out.println(mapB);


        for (int i = 0; i < mapA.size(); i++) {
            if(mapA.get((char) i)==0){
                mapA.remove((char) i);
            }
            if(mapB.get((char) i)==0){
                mapB.remove((char) i);
            }
        }

        for (int i = 0; i < mapA.size(); i++) {
            if (!mapA.get(Character.forDigit((97 + i), 10)).equals(mapB.get(Character.forDigit((97 + i), 10)))) {
                return false;
            }
        }
        return true;
    }
}
