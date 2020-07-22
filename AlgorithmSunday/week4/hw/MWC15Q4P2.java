package week4.hw;

import java.util.*;

public class MWC15Q4P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> intList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            intList.add(sc.nextInt());
        }

        Collections.sort(intList);

        for (int i = 0; i < n; i++) {
            System.out.printf("%s ",(i%2==0)?intList.get(i/2):intList.get(intList.size()-1-i/2));
        }
    }
}
