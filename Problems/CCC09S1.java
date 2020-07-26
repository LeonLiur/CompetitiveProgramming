package Problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CCC09S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        List<Integer> coolList = new ArrayList<>();

        double startCube = Math.ceil(Math.cbrt(start));
        double endCube = Math.floor(Math.cbrt(end));

        for (double i = startCube; i <= endCube; i++) {
            if(Math.sqrt(Math.pow(i, 3)) == (int) Math.sqrt(Math.pow(i, 3))){
                coolList.add((int)Math.pow(i, 3));
            }
        }
        System.out.println(coolList.size());

    }
}
