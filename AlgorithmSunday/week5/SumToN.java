package week5;

public class SumToN {
    public static void main(String[] args) {
        System.out.println(recursion(5));
    }

    private static int recursion(int n) {
        if (n / 10 == 0) {
            if (n % 10 == 5) {
                return 1;
            }
        }
        return n + recursion(n - 1);
    }
}
