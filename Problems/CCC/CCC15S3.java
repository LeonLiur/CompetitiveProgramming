package Problems.CCC;

import java.util.Scanner;
import java.util.TreeSet;

public class CCC15S3 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int G = sc.nextInt();
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i=1; i<=G; i++) {
            ts.add(i);
        }
        int P = sc.nextInt();
        int count = 0;
        for (int i=0; i<P; i++) {
            int plane = sc.nextInt();
            Integer port = ts.floor(plane);
            if (port==null) {
                break;
            } else {
                count++;
                ts.remove(port);
            }
        }
        System.out.println(count);
    }
}
