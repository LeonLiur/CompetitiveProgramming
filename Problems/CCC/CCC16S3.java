package Problems.CCC;

/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;


public class CCC16S3 {

    //https://pastebin.com/LTr0dLnN <-- DFS code
    static ArrayList<Integer> graph[];
    static int restaurants[];
    static boolean isARestaurant[];
    static int rt;
    static int par[];
    static boolean isPartOfTree[];
    static int dist[];

    static void dfs1(int n){
        for(int e : graph[n]){
            if(e != par[n]){
                par[e] = n;
                dfs1(e);
            }
        }
    }

    static void dfs2(int n){
        for(int e : graph[n]){
            if(isPartOfTree[e] && dist[e] > dist[n] + 1){
                dist[e] = dist[n] + 1;
                dfs2(e);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        restaurants = new int[M];
        isARestaurant = new boolean[N];
        for(int i = 0; i<M; i++){
            int n = sc.nextInt();
            restaurants[i] = n;
            isARestaurant[n] = true;
        }
        graph = new ArrayList[N];
        for(int i = 0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i<N-1; i++){
            int a = sc.nextInt(), b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        rt = restaurants[0];
        par = new int[N];
        isPartOfTree = new boolean[N];
        isPartOfTree[rt] = true;
        par[0] = -1;
        dfs1(rt);
        int numberOfNodesInNewTree = 1;
        for(int k : restaurants){
            int c = k;
            while(!isPartOfTree[c]){
                isPartOfTree[c] = true;
                numberOfNodesInNewTree++;
                c = par[c];
            }
        }
        dist = new int[N];
        Arrays.fill(dist, 3*N);
        dist[rt] = 0;
        dfs2(rt);
        int d1 = restaurants[0];
        for(int i = 0; i<N; i++){
            if(isPartOfTree[i] && dist[d1] < dist[i]){
                d1 = i;
            }
        }
        Arrays.fill(dist, 3*N);
        dist[d1] = 0;
        dfs2(d1);
        int d2 = restaurants[0];
        for(int i = 0; i<N; i++){
            if(isPartOfTree[i] && dist[d2] < dist[i]){
                d2 = i;
            }
        }
        //System.out.println(numberOfNodesInNewTree);
        //System.out.println(dist[d2]);
        System.out.println(numberOfNodesInNewTree*2 - 2 - dist[d2]);
    }
}

