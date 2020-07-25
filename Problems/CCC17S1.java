package Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CCC17S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bfr.readLine());
        int latest = 0;

        int[] a = new int[n];
        int[] b = new int[n];

        String line1 = bfr.readLine();
        String line2 = bfr.readLine();

        StringTokenizer stk1 = new StringTokenizer(line1);
        StringTokenizer stk2 = new StringTokenizer(line2);

        a[0] = Integer.parseInt(stk1.nextToken());
        b[0] = Integer.parseInt(stk2.nextToken());

        if(a[0] == b[0]){
            latest = 1;
        }

        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + Integer.parseInt(stk1.nextToken());
            b[i] = b[i - 1] + Integer.parseInt(stk2.nextToken());

            if(a[i] == b[i]){
                latest = i + 1;
            }
        }
        System.out.println(latest);
    }

}
