package Problems.TriwayFinal;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            pq.add(sc.nextLine());
        }

        while (!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}
