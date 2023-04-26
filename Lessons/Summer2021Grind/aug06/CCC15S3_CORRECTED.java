package Summer2021.aug06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CCC15S3_CORRECTED {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int G, P;
        G = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        boolean planedown;

        boolean[] docking_space = new boolean[G+1];
        int docked = 0;

        for (int i = 0; i < P; i++) {
            planedown = false;
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            for (int j = g; j >= 1; j--) {
                if(!docking_space[j]) {
                    docking_space[j] = true;
                    docked++;
                    planedown = true;
                    break;
                }
            }
            if(!planedown){
                break;
            }
        }

        System.out.println(docked);
    }
}
