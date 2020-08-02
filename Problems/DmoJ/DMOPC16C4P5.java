package Problems.DmoJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DMOPC16C4P5 {
    private final static int MAX = Integer.MAX_VALUE;
    private final static int MIN = -1;
    static int V;
    static int E;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        line = bf.readLine();

        StringTokenizer st = new StringTokenizer(line);
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int[][] graph = new int[V][V];

        for (int i = 0; i < E; i++) {
            line = bf.readLine();
            st = new StringTokenizer(line);
            int bv = Integer.parseInt(st.nextToken());
            int ev = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[bv - 1][ev - 1] = graph[ev - 1][bv - 1] = cost;
        }

//        for (int[] c:graph
//             ) {
//            for (int x:c
//                 ) {
//                System.out.print(x + " ");
//            }
//            System.out.println();
//        }

        System.out.println(0);
        for (int i = 1; i < V; i++) {
//            System.out.println(prim(i, graph));
            prim(i, graph);
        }
    }

    private static int findMax(int[] lowCost, boolean[] mstSet) {
        int max = MIN;
        int max_index = 0;
        for (int i = 0; i < lowCost.length; i++) {
            if (!mstSet[i] && lowCost[i] > max) {
                max = lowCost[i];
                max_index = i;
            }
        }
        return max_index;
    }

    private static int prim(int dest, int[][] graph) {
        int worst = MAX;

        int[] lowCost = new int[V];
        Arrays.fill(lowCost, MIN);

        boolean[] mstSet = new boolean[V];

        for (int i = 0; i < dest; i++) {
            int u = findMax(lowCost, mstSet);
            mstSet[u] = true;
//            System.out.println("Correct u: " + u);
            for (int j = 0; j < V; j++) {
                if (graph[u][j] != 0 && !mstSet[j] && graph[u][j] < lowCost[j]) {
                    lowCost[j] = graph[u][j];
                    worst = Math.min(worst, graph[u][j]);
                }
            }
            for (int x:lowCost
                 ) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        return worst;
    }
}
