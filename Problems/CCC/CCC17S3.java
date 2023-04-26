package Problems.CCC;

import java.util.Arrays;
import java.util.Scanner;

public class CCC17S3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int [] woods = new int[2001];
        int N = sc.nextInt();
        for (int i = 0; i < N; i++){
            int h = sc.nextInt();
            woods[h]++;
        }

        int[] fence = new int[4001];

        for (int h1 = 1; h1<2001; h1++) {
            for (int h2 = h1; h2<2001; h2++) {
                //h1 is the height of the first wood
                //h2 is the height of the second wood
                if (h1==h2) {
                    fence[h1+h2] += woods[h1]/2;
                } else {
                    fence[h1+h2] += Math.min(woods[h1], woods[h2]);
                }
            }
        }

        Arrays.sort(fence);
        int max = fence[4000];  //max fence length
        int count = 0;  //# of ways to reach max fence length

        for (int i=4000; i>0; i--) {
            if(!(fence[i]==max)) {
                break;
            } else {
                count++;
            }
        }

        System.out.println(max+" "+count);


    }
}
