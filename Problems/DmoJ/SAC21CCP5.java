package Problems.DmoJ;

import java.util.Arrays;
import java.util.Scanner;

public class SAC21CCP5 {
    static int[] dsj;
    static int[] size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        dsj = new int[N + 5];
        size = new int[N + 5];
        Arrays.fill(size, 1);
        
        for(int i = 0; i < dsj.length; i++){
            dsj[i] = i;
        }

        for (int i = 0; i < Q; i++) {
            if (sc.nextInt() == 1) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                if (find(x) != find(y)) {
                    union(x, y);
                }
            } else {
                int x = sc.nextInt();
                System.out.println(size[find(x)]);
            }
        }
    }

    private static int find(int x) {
        if (x == dsj[x])
            return x;
        return dsj[x] = find(dsj[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        dsj[y] = x;
        size[x] += size[y];
    }
}
