package Problems.CCC;

import java.util.Scanner;
import java.util.TreeMap;

public class CCC20S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double speed = 0;
        int n = sc.nextInt();
        TreeMap<Integer, Integer> myMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            myMap.put(sc.nextInt(), sc.nextInt());
        }


        Integer firstKey = myMap.firstKey();
        Integer firstVal = myMap.get(firstKey);
        for (int i = 1; i < n; i++) {
            myMap.remove(firstKey);
            Integer secondKey = myMap.firstKey();
            Integer secondVal = myMap.get(secondKey);

//            System.out.println(firstKey + " " + firstVal + " " + secondKey + " " + secondVal);
//            System.out.println(myMap);

            double newSpeed = Math.abs((double)(secondVal-firstVal))/(double)(secondKey - firstKey);
            speed = Math.max(newSpeed, speed);

            firstKey = secondKey;
            firstVal = secondVal;
        }
        System.out.println(speed);
    }
}
