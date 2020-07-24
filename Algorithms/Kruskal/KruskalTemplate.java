package Algorithms.Kruskal;

import java.util.*;
import java.lang.*;
import java.io.*;

public class KruskalTemplate{
    class Graph{
        class Edge implements Comparable<Edge>{
            int src, dest, weight;

            public int compareTo(Edge comparedEdge){
                return this.weight - comparedEdge.weight;
            }

        };

        class subset{
            int parent, rank;
        }
    }
}