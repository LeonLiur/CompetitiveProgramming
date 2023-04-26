package Problems.DmoJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NCCC18J5S3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Integer>[] adjList = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++){
            adjList[i] = new ArrayList<>();
        }
        int[][] order = new int[M][2];

        for(int i = 0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            adjList[a].add(b);


            order[i][0] = a;
            order[i][1] = b;
        }

        for(int i = 0; i < M; i++){
            adjList[order[i][0]].remove(Integer.valueOf(order[i][1]));

            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            boolean[] visited = new boolean[N + 1];
            boolean flag = false;
            while(!q.isEmpty()){
                int cur = q.poll();
                // System.out.println(cur);
                visited[cur] = true;
                for (int b : adjList[cur]) {
                    if(b == N){
                        flag = true;
                        break;
                    }
                    if(!visited[b]){
                        q.add(b);
                    }
                }
            }

            System.out.println(flag?"YES":"NO");

            
            adjList[order[i][0]].add(Integer.valueOf(order[i][1]));
        }
    }
}
