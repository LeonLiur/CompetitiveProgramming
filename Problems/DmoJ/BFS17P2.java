package Problems.DmoJ;

import java.util.Arrays;
import java.util.Scanner;

public class BFS17P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] counts = new int[6];
        // Red, orange, yellow, green, blue, black

        for(int i = 0; i < N; i++){
            switch(sc.next()){
                case "red":
                    counts[0] += 1;
                    break;
                case "orange":
                    counts[1] += 1;
                    break;
                case "yellow":
                    counts[2] += 1;
                    break;
                case "green":
                    counts[3] += 1;
                    break;
                case "blue":
                    counts[4] += 1;
                    break;
                case "black":
                    counts[5] += 1;
                    break;
            }
        }

        
        Arrays.sort(counts);
        long answer = Math.min(counts[counts.length - 1], N - counts[counts.length - 1] + 1) + N - counts[counts.length - 1];
        System.out.println(answer);
    }
}
