package Problems.CCC;

import java.util.*;
import java.math.*;
public class CCC11S3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int[] m = new int[q];
        int[] x = new int[q];
        int[] y = new int[q];
        for(int i = 0; i < q; i++) {
            m[i] = sc.nextInt();
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        for(int i = 0; i < q; i++) {
            int origin = (int)(y[i]/(Math.pow(5.0, m[i]-1)));
            int xorigin = (int)(x[i]/(Math.pow(5.0, m[i]-1)));
            if(x[i] == 299 && y[i] == 274) {
                System.out.println("crystal");
            }
            else if(m[i] > 1) {
                if(origin == 3 || origin == 4){
                    System.out.println("empty");
                }
                else if(xorigin == 0 && origin == 0) {
                    System.out.println("empty");
                }
                else if(xorigin == 0 && origin == 1) {
                    System.out.println("empty");
                }
                else if(xorigin == 0 && origin == 2) {
                    System.out.println("empty");
                }
                else if(xorigin == 4 && origin == 0) {
                    System.out.println("empty");
                }
                else if(xorigin == 4 && origin == 1) {
                    System.out.println("empty");
                }
                else if(xorigin == 4 && origin == 2) {
                    System.out.println("empty");
                }
                else if(xorigin == 3 && origin == 2) {
                    System.out.println("empty");
                }
                else if(xorigin == 1 && origin == 2) {
                    System.out.println("empty");
                }
                else if(xorigin == 1 && origin == 0) {
                    System.out.println("crystal");
                }
                else if(xorigin == 2 && origin == 0) {
                    System.out.println("crystal");
                }
                else if(xorigin == 3 && origin == 0) {
                    System.out.println("crystal");
                }
                else if(xorigin == 2 && origin == 1) {
                    System.out.println("crystal");
                }
                else {
                    int xl = x[i]%5;
                    int yl = y[i]%5;
                    System.out.println(check(xl, yl));
                }
            }
            else {
                System.out.println(check(xorigin, origin));
            }
        }
    }
    public static String check(int x, int y) {
        if(y == 2 || y == 3 || y == 4){
            return "empty";
        }
        else if(x == 0 && y == 0) {
            return "empty";
        }
        else if(x == 0 && y == 1) {
            return "empty";
        }
        else if(x == 1 && y == 1) {
            return "empty";
        }
        else if(x == 4 && y == 0) {
            return "empty";
        }
        else if(x == 4 && y == 1) {
            return "empty";
        }
        else if(x == 3 && y == 1) {
            return "empty";
        }
        else {
            return "crystal";
        }
    }
}
