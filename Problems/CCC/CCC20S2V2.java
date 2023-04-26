package CCC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CCC20S2V2 {
    static ArrayList<ArrayList<Cell>> table;
    static boolean[][] visited = new boolean[1000][1000];

    static class Cell{
        int m;
        int n;
        int value;

        public Cell(int m, int n, int value) {
            this.m = m;
            this.n = n;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "m=" + m +
                    ", n=" + n +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        table = new ArrayList<>();

        ArrayList<Cell> firstRow = new ArrayList<>();
        for (int j = 0; j < N; j++) {
            Cell newCell = new Cell(Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE);
            firstRow.add(newCell);
        }

        table.add(firstRow);
        for (int i = 1; i < M+1; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            ArrayList<Cell> newrow = new ArrayList<>();
            newrow.add(new Cell(Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE));
            for (int j = 1; j < N+1; j++) {
                Cell newCell = new Cell(i, j, Integer.parseInt(st.nextToken()));
                newrow.add(newCell);
            }
            table.add(newrow);
        }
        System.out.println(bfs(table.get(M).get(N)));


    }

    private static String bfs(Cell lastCell){
        Queue<Cell> cellQueue = new LinkedList<>();
        cellQueue.add(lastCell);
        while(!cellQueue.isEmpty()) {
            Cell cur = cellQueue.poll();
            visited[cur.m][cur.n] = true;
            if (cur.m == 1 && cur.n == 1) {
                return "yes";
            }

            for (int i = 1; i < table.size(); i++) {
                for (int j = 1; j < table.get(1).size(); j++) {
                    if (table.get(i).get(j).value == cur.m * cur.n && !visited[i][j]) {
                        cellQueue.add(table.get(i).get(j));
                    }
                }
            }
        }
        return "no";
    }
}
