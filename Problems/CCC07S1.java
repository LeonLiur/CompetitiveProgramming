package Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CCC07S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if(y > 1989){
                System.out.println("No");
            }else if(y == 1989){
                if(m > 2){
                    System.out.println("No");
                }else if(m == 2){
                    if(d > 27){
                        System.out.println("No");
                    }else{
                        System.out.println("Yes");
                    }
                }else{
                    System.out.println("Yes");
                }
            }else{
                System.out.println("Yes");
            }
        }
    }

}
