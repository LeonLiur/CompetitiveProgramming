package week3;

        import java.util.Scanner;

public class BTS18P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int q = Integer.parseInt(sc.nextLine());
        int[][] letters = new int[s.length()][26];
        letters[0][s.charAt(0)-97] = 1;

        for (int i = 1; i < s.length(); i++) {
            letters[i] = letters[i-1].clone();
            char c = s.charAt(i);
            if(c == 32){
                continue;
            }
            letters[i][c - 97] = letters[i-1][c - 97] + 1;

        }



        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            char c = sc.next().toCharArray()[0];
            if(a >= 2) {
                System.out.println(letters[b - 1][c - 97] - letters[a - 2][c - 97]);
            }else{
                System.out.println(letters[b - 1][c - 97]);
            }
        }
    }
}
