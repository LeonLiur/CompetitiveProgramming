package Problems.CCC;

import java.util.*;
import java.io.*;

public class CCC12S4 {
    static int n;
    static int[] start = new int[8];
    static int[] expo = {1, 7, 128, 2187, 16384, 78125, 279936, 823543};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    static class State {
        // current game variable, each index represents a cell in the grid
        ArrayList<Integer>[] curBoard;
        int moves;
        int id;

        State(ArrayList<Integer>[] curBoard, int moves, int id) {            
            this.curBoard = curBoard;
            this.moves = moves;
            this.id = id;
        }
    }
    static Set<Integer> visited = new HashSet<>();

    private static boolean checkEnd(ArrayList<Integer>[] curBoard) {
        for (int i = 0; i < n; i++) {
            if (curBoard[i].isEmpty()) {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
            // check if the cells are in positive order
            if (curBoard[i].size() != 1 || curBoard[i].get(0) != i + 1) {
                return false;
            }
        }
        return true;
    }


    private static int bfs() {
        Queue<State> q = new LinkedList<>();

        ArrayList<Integer>[] startBoard = new ArrayList[8];
        int resStart = 0;
        for (int j = 0; j < 8; j++) {
            startBoard[j] = new ArrayList<Integer>();
            startBoard[j].add(start[j]);
            resStart += j * expo[start[j]];
        }

        q.add(new State(startBoard, 0, resStart));

        while (!q.isEmpty()) {
            State cur = q.poll();
            ArrayList<Integer>[] curBoard = cur.curBoard;
            int curMoves = cur.moves;
            int id = cur.id;

            if (visited.contains(id)) {
                continue;
            } else {
                visited.add(id);
            }

            if (checkEnd(curBoard)) {
                return curMoves;
            }

            for (int i = 0; i < n; i++) {
                if (curBoard[i].isEmpty()) {
                    continue;
                }
                if (i >= 1) {
                    int leftTop = curBoard[i - 1].isEmpty() ? Integer.MAX_VALUE : curBoard[i - 1].get(curBoard[i - 1].size() - 1);
                    int currTop = curBoard[i].get(curBoard[i].size() - 1);

                    if (curBoard[i - 1].isEmpty() || leftTop > currTop) {
                        curBoard[i - 1].add(currTop);
                        curBoard[i].remove(Integer.valueOf(currTop));
                        ArrayList<Integer>[] newBoard = new ArrayList[8];
                        int res = 0;
                        for (int j = 0; j < 8; j++) {
                            newBoard[j] = new ArrayList<Integer>();
                            for(int k : curBoard[j]){
                                newBoard[j].add(k);
                                res += j * expo[k] % 1000000007;
                            }
                        }
                        State newState = new State(newBoard, curMoves + 1, res);
                        q.add(newState);
                        // revert changes
                        curBoard[i].add(currTop);
                        curBoard[i - 1].remove(Integer.valueOf(currTop));
                    }
                }
                if (i <= n - 2) {
                    int rightTop = curBoard[i+1].isEmpty() ? Integer.MAX_VALUE : curBoard[i + 1].get(curBoard[i+1].size() - 1);
                    int currTop = curBoard[i].get(curBoard[i].size() - 1);

                    if (curBoard[i + 1].isEmpty() || rightTop > currTop) {
                        curBoard[i + 1].add(currTop);
                        curBoard[i].remove(Integer.valueOf(currTop));

                        ArrayList<Integer>[] newBoard = new ArrayList[8];
                        int res = 0;
                        for (int j = 0; j < 8; j++) {
                            newBoard[j] = new ArrayList<Integer>();
                            for(int k : curBoard[j]){
                                newBoard[j].add(k);
                                res += j * expo[k] % 1000000007;
                            }
                        }
                        State newState = new State(newBoard, curMoves + 1, res);
                        q.add(newState);
                        // revert changes
                        curBoard[i].add(currTop);
                        curBoard[i + 1].remove(Integer.valueOf(currTop));
                    }
                }
            }
        }
        return -1;
    }

    public static void main (String[] args) throws IOException{
        while(true){
            n = readInt();
            if(n == 0)  break;
            for(int i = 0; i < n; i++){
                start[i] = readInt();
            }
            int ans = bfs();
            if(ans == -1)   System.out.println("IMPOSSIBLE");
            else    System.out.println(ans);

            visited.clear();
        }
    }

    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
