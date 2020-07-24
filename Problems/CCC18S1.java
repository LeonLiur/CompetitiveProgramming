package Problems;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

public class CCC18S1 {
    public static void main(String[] args) {
        double x, y, z;
        int n;
        double smallest;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        double[] villages = new double[n];

        for (int i = 0; i < n; i++) {
            villages[i] = sc.nextDouble();
        }

        Arrays.sort(villages);
        x = villages[0];
        y = villages[1];
        z = villages[2];
        smallest = (z-y)/2 + (y-x)/2;

        for (int i = 3; i < villages.length; i++) {
            x = y;
            y = z;
            z = villages[i];

            if(((z-y)/2 + (y-x)/2) < smallest){
                smallest = Math.abs(((z-y)/2 + (y-x)/2));
            }

        }

        NumberFormat formatter = new DecimalFormat("#0.00");

        System.out.println(formatter.format(Double.parseDouble(String.valueOf(smallest))));
    }
}