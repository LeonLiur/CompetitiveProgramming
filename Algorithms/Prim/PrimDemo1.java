package Algorithms.Prim;

import java.util.Arrays;
import java.util.Scanner;

public class PrimDemo1 {
    final static int MIN_VAL = -1;
    final static int MAX_VAL = Integer.MAX_VALUE;
    static int[] parent;
    static int[][] graph;
    static int[] lowCost;
    static boolean[] mstSet;
    static int V;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        int E = sc.nextInt();

        graph = new int[V][V];
        for (int i = 0; i < E; i++) {
            int bv = sc.nextInt();
            int ev = sc.nextInt();
            int cost = sc.nextInt();

            graph[bv][ev] = graph[ev][bv] = cost;
        }

        parent = new int[V];
        Arrays.fill(parent, MIN_VAL);

        lowCost = new int[V];
        Arrays.fill(lowCost, MAX_VAL);

        mstSet = new boolean[V];

        prim();
    }
    private static int findMin(){
        int min = MAX_VAL;
        int min_index = 0;
        for (int i = 0; i < lowCost.length; i++) {
            if (!mstSet[i] && min > lowCost[i]){
                min_index = i;
                min = lowCost[i];
            }
        }

        return min_index;
    }


    private static void prim(){
        lowCost[0] = 0;
        for (int j = 0; j < V - 1; j++) {
            int minIndex = findMin();
            mstSet[minIndex] = true;
            for (int k = 0; k < V; k++) {
                if(graph[minIndex][k] != 0 && !mstSet[k] && lowCost[k] > graph[minIndex][k]){
                    lowCost[k] = graph[minIndex][k];
                    parent[k] = minIndex;
                }
            }

        }
        printMST();
    }

    private static void printMST()
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }
}
