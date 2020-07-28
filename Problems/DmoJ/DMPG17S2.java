package Problems.DmoJ;

import java.util.Arrays;
import java.util.Scanner;

public class DMPG17S2 {
    public static int[] rootList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int N = sc.nextInt();

        rootList = new int[V];
        Arrays.fill(rootList, -1);

        for (int i = 0; i < N; i++) {
            char t = sc.next().charAt(0);
            if (t == 'A') {
                union(sc.nextInt() - 1, sc.nextInt() - 1);
            } else {
                int bR = find(sc.nextInt() - 1);
                int eR = find(sc.nextInt() - 1);
                System.out.println(bR == eR ? 'Y' : 'N');
            }
        }
    }


    private static void union(int bR, int eR) {
        if(find(bR) != find(eR)){
            rootList[find(bR)] = find(eR);
        }
    }

    private static int find(int bV) {
        if (rootList[bV] == -1) {
            return bV;
        }else{
            return rootList[bV] = find(rootList[bV]);
        }

    }
}

