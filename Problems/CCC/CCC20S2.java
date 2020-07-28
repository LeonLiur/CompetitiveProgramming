package Problems.CCC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCC20S2 {
    static int[][] chart;
    static int m;
    static int n;
    static ArrayList<Integer[]> visited = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        chart = new int[m][n];

        for (int i = 0; i < m; i++) {
            chart[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        findValid(m, n);
    }

    private static void findValid(int x, int y) {
        int currentVal = chart[x - 1][y - 1];
        Integer[] curr = new Integer[]{x, y};
        if (x == 1 && y == 1) {
            System.out.println("yes");
            System.exit(0);
        }
        for (Integer[] entry:visited
             ) {
            if(entry[0].equals(curr[0]) && entry[1].equals(curr[1])){
                System.out.println("no");
                System.exit(0);
            }else{
                visited.add(curr);
            }
        }

        Queue<Integer> queue = findFactors(currentVal);
        while (!queue.isEmpty()) {
            int p = queue.poll();
            int q = currentVal / p;
            if (p <= m && q <= n) {
                findValid(p, q);
            }
        }

    }

    private static Queue<Integer> findFactors(int start) {
        int skip = start % 2 == 0 ? 1 : 2;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < start; i += skip) {
            if (start % i == 0) {
                queue.add(i);
            }
        }
        return queue;
    }

}