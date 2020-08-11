package Problems.CCC;

import java.util.Scanner;

public class CCC09S2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int l = sc.nextInt();

        boolean[][] grid = new boolean[r][l];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < l; j++) {
                grid[i][j] = sc.nextInt()==1;
            }
        }
    }
}
