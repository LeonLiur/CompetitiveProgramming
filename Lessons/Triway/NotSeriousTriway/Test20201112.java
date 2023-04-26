package Triway.NotSeriousTriway;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Test20201112 {
    static class Edge implements Comparable<Edge>
    {
        int src, dest, weight;

        public int compareTo(Edge compareEdge)
        {
            return this.weight - compareEdge.weight;
        }

        Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        PriorityQueue<Edge> edgeQueue = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            edgeQueue.add(new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt()));
        }

        Edge mst[] = new Edge[V];


    }

    private static void union(){

    }


}
