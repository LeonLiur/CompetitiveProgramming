package Problems.DmoJ;

import java.util.Scanner;

public class DMOPC21C1P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N + 1];
        long tempA = 0l;

        System.out.println("? 1 2");
        System.out.flush();
        long temp1 = sc.nextLong();
        System.out.println("? 1 2");
        System.out.flush();
        long temp2 = sc.nextLong();

        arr[1] = (temp2 + 2 * temp1) / 2;
        arr[2] = temp2 / 2;

        for (int i = 2; i < N; i++) {
            System.out.println("? " + i + " " + (i + 1));
            System.out.flush();
            long temp = sc.nextLong();
            arr[i + 1] = i == 2 ? 2 * arr[i] - temp : tempA - temp;
            tempA = temp;
        }

        System.out.print("! ");

        for (int i = 1; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[N]);
    }
}
