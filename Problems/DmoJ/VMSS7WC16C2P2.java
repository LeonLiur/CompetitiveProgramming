package Problems.DmoJ;

import java.util.Scanner;

public class VMSS7WC16C2P2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int[] psa = new int[s.length() + 2];
        
        psa[0] = s.charAt(0) == 'G'?1:0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == 'G'){
                psa[i] = psa[i-1] + 1;
            }else{
                psa[i] = psa[i-1];
            }
        }

        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(x == 0 && y != s.length() - 1){
                System.out.println(Math.abs(psa[y]));
            }else if(x != 0 && y == s.length() - 1){
                System.out.println(Math.abs(psa[y] - psa[x - 1]));
            }else if(x == 0 && y == s.length() - 1){
                System.out.println(Math.abs(psa[y]));
            }else{
                System.out.println(Math.abs(psa[y] - psa[x - 1]));
            }
            
        }

        // for (int i : psa) {
        //     System.out.println(i);
        // }

      

    }
}