package Summer2021.aug19;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 2021-08-19
// Very successful, mastering BFS algorithm:
// Completed from 21:30 - 22:00

public class CCC08S3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            char[][] grid = new char[sc.nextInt()][sc.nextInt()];
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            for (int j = 0; j < grid.length; j++) {
                grid[j] = sc.next().toCharArray();
            }

            Queue<int[]> bfs = new LinkedList<>();
            bfs.add(new int[]{0, 0, 1});

            while (!bfs.isEmpty()) {
                int[] cur = bfs.poll();

                if (cur[1] < 0 || cur[1] > grid[0].length - 1 || cur[0] < 0 || cur[0] > grid.length - 1 || grid[cur[0]][cur[1]] == '*' || visited[cur[0]][cur[1]]) {
                    continue;
                }
                visited[cur[0]][cur[1]] = true;

                if (cur[0] == grid.length - 1 && cur[1] == grid[0].length - 1) {
                    System.out.println(cur[2]);
                    break;
                }

                if (grid[cur[0]][cur[1]] == '+') {
                    bfs.add(new int[]{cur[0] - 1, cur[1], cur[2] + 1});
                    bfs.add(new int[]{cur[0], cur[1] - 1, cur[2] + 1});
                    bfs.add(new int[]{cur[0] + 1, cur[1], cur[2] + 1});
                    bfs.add(new int[]{cur[0], cur[1] + 1, cur[2] + 1});
                } else if (grid[cur[0]][cur[1]] == '|') {
                    bfs.add(new int[]{cur[0] - 1, cur[1], cur[2] + 1});
                    bfs.add(new int[]{cur[0] + 1, cur[1], cur[2] + 1});
                } else {
                    bfs.add(new int[]{cur[0], cur[1] - 1, cur[2] + 1});
                    bfs.add(new int[]{cur[0], cur[1] + 1, cur[2] + 1});
                }
            }
            if (!visited[grid.length - 1][grid[0].length - 1]) {
                System.out.println("-1");
            }
        }
    }
}
