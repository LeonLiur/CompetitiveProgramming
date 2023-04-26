package Triway.SeriousTriway.class20201217;

import java.util.*;

public class KruskalTemplate {
    public static int[] parent;

    public static class Edge implements Comparable<Edge> {
        int bv;
        int ev;
        int cost;

        public Edge(int bv, int ev, int cost) {
            this.bv = bv;
            this.ev = ev;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        LinkedList<Edge> edges = new LinkedList<>();
        for (int i = 0; i < E; i++) {
            edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(edges);

        parent = new int[V];
        Arrays.fill(parent, -1);
        int index = 0;
        int sum = 0;
        for (Edge cur : edges) {
            int root1 = find(cur.bv);
            int root2 = find(cur.ev);
            if (root1 != root2) {
                sum += cur.cost;
                union(root1, root2);
                index++;
                if (index == V - 1) {
                    break;
                }
            }
        }
        System.out.println(sum);


    }


    //find function to find out root parent
    public static int find(int v) {
        if (parent[v] == -1) {
            return v;
        }
        parent[v] = find(parent[v]);
        return parent[v];
    }

    //union function to join the edge together
    public static void union(int pb, int pe) {
        parent[pb] = pe;
    }
}