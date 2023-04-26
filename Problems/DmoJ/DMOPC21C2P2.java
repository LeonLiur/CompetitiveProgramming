package Problems.DmoJ;

import java.util.ArrayList;
import java.util.Scanner;

public class DMOPC21C2P2{
    public static void main(String[] args) {
        ArrayList<Integer[]> ar = new ArrayList<Integer[]>();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        for(int i = 0; i < Q; i++){
            String chara = sc.next();
            if(chara.equals("B")){
                Integer[] temp = {sc.nextInt(), sc.nextInt()};
                ar.add(0, temp);
            }else if (chara.equals("E")){
                Integer[] temp = {sc.nextInt(), sc.nextInt()};
                ar.add(temp);
            }else{
                int[] temp = new int[N];
                for(int j = 0;j < N; j++){
                    temp[j] = sc.nextInt();
                }

                for(int k = ar.size() - 1; k >= 0; k--){
                    
                }

                int[] pos = new int[N];

                // int[] mapping = new int[N];
                // for(int i = 0; i < N; i++){
                //     mapping[i]
                // }
            }
        }
    }
}