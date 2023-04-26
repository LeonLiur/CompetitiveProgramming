package Problems.MockCCC2021;

import java.util.Scanner;

public class DWITE10C1P4 {
    private static double triangleArea(int x1, int y1, int x2, int y2,
                       int x3, int y3)
    {
//        System.out.println(x1 + " " + y1 + " " + x2 + " " + y2 + " " + x3 + " " + y3);
        return Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0);
    }

    private static boolean checkTriangle(int x1, int x2, int x3, int y1, int y2, int y3, int x, int y){
        double areaMain = triangleArea(x1, y1, x2, y2, x3, y3);
//        System.out.println("area main: " + areaMain);
        double area1 = triangleArea(x, y, x1, y1, x2, y2);
//        System.out.println("area 1: " + area1);
        double area2 = triangleArea(x, y, x1, y1, x3, y3);
//        System.out.println("area 2: " + area2);
        double area3 = triangleArea(x, y, x2, y2, x3, y3);
//        System.out.println("area 3: " + area3);

        return area1 + area2 + area3 == areaMain && areaMain != 0 && area1 != 0 && area2 != 0 && area3 != 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int N = sc.nextInt();
            int[][] store = new int[N][2];
            for (int j = 0; j < N; j++) {
                store[j][0] = sc.nextInt();
                store[j][1] = sc.nextInt();
            }

            int validCounter = 0;
            for (int j = 0; j < N-2; j++) {
                int[] pair1 = store[j];
                for (int k = j+1; k < N-1; k++) {
                    int[] pair2 = store[k];
                    for (int l = k+1; l < N; l++) {
                        int[] pair3 = store[l];

                        validCounter += (checkTriangle(pair1[0], pair2[0], pair3[0], pair1[1], pair2[1], pair3[1], 0, 0))?1:0;
//                        System.out.println("Checked pair: " + pair1[0] + " " +  pair2[0]+ " " +pair3[0]+ " " +pair1[1]+ " " +pair2[1]+ " " +pair3[1] + " Valid counter: " + validCounter);
                    }
                }
            }
            System.out.println(validCounter);
        }
    }
}
