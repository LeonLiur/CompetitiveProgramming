package Algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CCC09S3 {
    public static void main(String[] args) {
        boolean[][] adj = new boolean[51][51];
        int[][] connections = {{}, {6}, {6}, {4,5,6,15}, {3,5,6}, {3,4,6}, {1,2,3,4,5,7}, {6,8}, {7,9}, {8,10,12}, {9,11}, {10,12}, {9,11,13}, {12,14,15}, {13}, {3,13}, {17,18}, {16,18}, {16,17}};
        for (int i = 1; i < connections.length; i++) {
            for (int x:connections[i]
                 ) {
                adj[i][x] = true;
                adj[x][i] = true;
            }
        }

        Scanner sc = new Scanner(System.in);
        while (true){
            String operation = sc.next();
            switch (operation) {
                case "i": {
                    int x = sc.nextInt();
                    int y = sc.nextInt();

                    adj[x][y] = true;
                    adj[y][x] = true;
                    break;
                }
                case "d": {
                    int x = sc.nextInt();
                    int y = sc.nextInt();

                    adj[x][y] = false;
                    adj[y][x] = false;
                    break;
                }
                case "n": {
                    int x = sc.nextInt();
                    int counter = 0;
                    for (int n = 1; n < adj[x].length; n++) {
                        boolean k = adj[x][n];
                        counter += k ? 1 : 0;
                    }
                    System.out.println(counter);
                    break;
                }
                case "f": {
                    int x = sc.nextInt();
                    boolean[] visited = new boolean[51];
                    int counter = 0;

                    for (int i = 0; i < adj[x].length; i++) {
                        if (adj[x][i]) {
                            for (int j = 0; j < adj[i].length; j++) {
                                if (adj[i][j] && !adj[x][j] && !visited[j] && j != x) {
                                    counter++;
                                    visited[j] = true;
                                }
                            }
                        }
                    }

                    System.out.println(counter);
                    break;
                }
                case "s": {
                    Queue<Integer> myq = new LinkedList<>();
                    boolean[] visited = new boolean[51];
                    int start = sc.nextInt();
                    int end = sc.nextInt();
                    int[] dist = new int[51];
                    visited[start] = true;

                    myq.add(start);

                    while (!myq.isEmpty()) {
                        int current = myq.poll();

                        for (int j = 0; j < 51; j++) {
                            if (adj[current][j] && !visited[j]) {
                                myq.add(j);
                                visited[j] = true;
                                dist[j] = dist[current] + 1;
                            }
                        }
                    }

                    if (!visited[end]) {
                        System.out.println("Not connected");
                    } else {
                        System.out.println(dist[end]);
                    }

                    break;
                }
                case "q":
                    return;
            }
        }
    }
}
