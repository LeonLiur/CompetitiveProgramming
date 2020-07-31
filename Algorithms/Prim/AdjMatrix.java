package Algorithms.Prim;

import java.util.Scanner;

public class AdjMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] graph = new int[V][V];
        for (int i = 0; i < E; i++) {
            int bv = sc.nextInt();
            int ev = sc.nextInt();
            int cost = sc.nextInt();

            graph[bv][ev] = graph[ev][bv] = cost;
        }

        System.out.println(graph[0][0]);



    }
}
