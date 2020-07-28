package Problems.CCC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCC20S2 {
    static class Cell {
        protected int r;
        protected int c;
        protected int val;

        public Cell(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }

    static boolean[][] visited = new boolean[1000][1000];
    static ArrayList<ArrayList<Cell>> chart = new ArrayList<>();
    static ArrayList<Cell> cellWithVal = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < m; i++) {
            String line = bf.readLine();
            StringTokenizer st = new StringTokenizer(line);
            ArrayList<Cell> a = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                Cell cell = new Cell(i, j, Integer.parseInt(st.nextToken()));
                a.add(cell);
            }
            chart.add(a);
        }

        System.out.println(is_possible(chart.get(m-1).get(n-1))?"yes":"no");
    }

    private static boolean is_possible(Cell lastCell) {
        Queue<Cell> cellQueue = new LinkedList<>();
        cellQueue.add(lastCell);
        while (!cellQueue.isEmpty()) {
            Cell current = cellQueue.poll();
            for (ArrayList<Cell> x : chart
            ) {
                for (Cell y : x
                ) {
                    if (y.val == (current.c + 1) * (current.r + 1)) {
                        cellWithVal.add(y);
                    }
                }
            }

            for (Cell c : cellWithVal
            ) {
                if (c.r == 0 && c.c == 0) {
                    return true;
                } else if (!visited[c.r][c.c]) {
                    visited[c.r][c.c] = true;
                    cellQueue.add(c);
                }
            }

        }
        return false;
    }

}