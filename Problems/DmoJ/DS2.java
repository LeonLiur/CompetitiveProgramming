package Problems.DmoJ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class DS2 {
    //https://dmoj.ca/problem/ds2

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        parent = new int[V];
        Arrays.fill(parent, -1);

        LinkedList<Integer> queue = new LinkedList<>();

        int total = 0;
        for (int i=0; i<E; i++) {
            int bv = sc.nextInt()-1;
            int ev = sc.nextInt()-1;
            int pb = find(bv);
            int pe = find(ev);
            if (pb!=pe) {
                queue.add(i+1);
                union(pb,pe);
                total++;
                if (total==V-1) {
                    break;
                }
            }
        }
        if (total==V-1) {
            while (!queue.isEmpty()) {
                System.out.println(queue.poll());
            }
        } else {
            System.out.println("Disconnected Graph");
        }
    }

    public static int[] parent;
    public static int find(int v) {
        if (parent[v]==-1) {
            return v;
        } else {
            parent[v] = find(parent[v]);
            return parent[v];
        }
    }
    public static void union(int pb, int pe)  {
        parent[pb] = pe;
    }
}