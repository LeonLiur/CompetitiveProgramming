package Algorithms.Prim;

import java.util.Arrays;
import java.util.Scanner;

public class PrimTemplateReview {
    static int V;
    static int[][] graph;
    static int[] parents;
    static boolean[] mstSet;
    static int[] vCosts;
    static int sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        int E = sc.nextInt();

        graph = new int[V][V];
        vCosts = new int[V];
        mstSet = new boolean[V];
        parents = new int[V];

        for (int i = 0; i < E; i++) {
            int bV = sc.nextInt();
            int eV = sc.nextInt();
            int cost = sc.nextInt();

            graph[bV][eV] = graph[eV][bV] = cost;
        }

        int start = 0;
        Arrays.fill(vCosts, Integer.MAX_VALUE);
        Arrays.fill(parents, -1);
        vCosts[start] = 0;

        for (int i = 0; i < V; i++) {
            int indMin = findMin();
            mstSet[indMin] = true;
            for (int j = 0; j < V; j++) {
                if(!mstSet[j] && graph[indMin][j] > 0 && graph[indMin][j] < vCosts[j]){
                    parents[j] = indMin;
                    vCosts[j] = graph[indMin][j];
                }
            }
        }
//        Output
        System.out.println("MST tree");
        for (int i=0; i<V; i++) {
            if (i!=start) {
                System.out.println(i+" "+parents[i]+" "+vCosts[i]);
            }
        }


    }


    private static int findMin(){
        int min_index = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < vCosts.length; i++) {
            if(!mstSet[i] && vCosts[i] < min){
                min_index = i;
                min = vCosts[i];
            }
        }
        return min_index;
    }

}
