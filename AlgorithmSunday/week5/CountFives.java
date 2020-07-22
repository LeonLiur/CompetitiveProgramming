package week5;

public class CountFives {
    private static int sum;

    public static void main(String[] args) {
        System.out.println(recursion(555));
    }

    private static int recursion(int n) {
        if (n / 10 == 0) {
            return n / 10 == 5 ? 1 : 0;
        }
        sum += n % 10 == 5 ? 1 : 0;
        return sum + recursion(n / 10);
    }
}
