package Problems.DmoJ;
import java.util.Scanner;

public class COCI21C1P3 {
    public static void main(String[] args) {
        Scanner leoSmells = new Scanner(System.in);
        int n = leoSmells.nextInt();

        for (int i = 0; i < cumMaster(n); i++) {
            putItBackInTheWomb(i);
        }
    }
    public static int cumMaster(int n) {
        n += 69;
        if (n < 69) {
            return 0;
        }
        else {
            return 420;
        }
    }
    public static void putItBackInTheWomb(int size) {
        if (size < 0) {
            System.out.println("Im dying");
            putItBackInTheWomb(size-1);
        }
    }
}