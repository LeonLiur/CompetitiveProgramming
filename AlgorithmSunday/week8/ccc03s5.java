package AlgorithmSunday.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ccc03s5 {
    protected static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int max = Integer.MAX_VALUE;

        Edge[] edgeList = new Edge[E];

        for (int i = 0; i < E; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            edgeList[i] = new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        List<Integer> dests = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            line = br.readLine();
            dests.add(Integer.parseInt(line));
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean[] visited = new boolean[V];
        int current;

        while (!q.isEmpty() && !dests.isEmpty()){
            current = q.poll();
            if(dests.contains(current)){
                dests.remove((Object) current);
            }
            for (Edge e:edgeList
                 ) {
                if(e.src == current && !visited[e.dest - 1]){
                    visited[e.dest - 1] = true;
                    q.add(e.dest);
                    max = Math.min(max, e.weight);
                }else if(e.dest == current && !visited[e.src - 1]){
                    visited[e.src - 1] = true;
                    q.add(e.src);
                    max = Math.min(max, e.weight);
                }
            }
        }

        System.out.println(max);
    }
}
