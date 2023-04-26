package Problems.CCC;

import java.util.Arrays;
import java.util.Scanner;

public class CCC07S2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] sizes = new int[n][3];

        for (int i = 0; i < n; i++) {
            sizes[i][0] = sc.nextInt();
            sizes[i][1] = sc.nextInt();
            sizes[i][2] = sc.nextInt();

            Arrays.sort(sizes[i]);
        }
        Arrays.sort(sizes);

        int m = sc.nextInt();
        int[] currentPack = new int[3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                currentPack[0] = sc.nextInt();
                currentPack[1] = sc.nextInt();
                currentPack[2] = sc.nextInt();
            }

            Arrays.sort(currentPack);

            for (int[] size : sizes
            ) {
                if(size[0] >= currentPack[0] && size[1] >= currentPack[1] && size[2] >= currentPack[2] ){
                    System.out.println(size[0]*size[1]*size[2]);
                }

            }
            System.out.println("Item does not fit.");
        }


    }
}
