package Algorithms.Prim;

import java.util.Arrays;
import java.util.Scanner;

public class PrimTemplate {
    private static boolean[] mstSet;
    private static int[] parent;
    private static int[] lowCost;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] graph = new int[V][V];
        for (int i = 0; i < E; i++) {
            int bV = sc.nextInt();
            int eV = sc.nextInt();
            int cost = sc.nextInt();
            graph[bV][eV] = graph[eV][bV] = cost;
        }

        mstSet = new boolean[V];

        parent = new int[V];
        Arrays.fill(parent, -1);

        lowCost = new int[V];
        Arrays.fill(lowCost, Integer.MAX_VALUE);

        int begin = 0;
        lowCost[begin] = 0;
        for (int i = 0; i < V; i++) {
            int n = findMin();
            mstSet[n] = true;
            for (int j = 0; j < V; j++) {
                if (!mstSet[j] && graph[n][j] != 0 && graph[n][j] < lowCost[j]) {
                    lowCost[j] = graph[n][j];
                    parent[j] = n;
                }
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.println(i + " " + parent[i] + " " + lowCost[i]);
        }
    }
    private static int findMin(){
        int min = Integer.MAX_VALUE;
        int min_index = 0;

        for (int i = 0; i < lowCost.length; i++) {
            if(!mstSet[i] && lowCost[i] < min){
                min_index = i;
                min = lowCost[i];
            }
        }
        return min_index;
    }

}
