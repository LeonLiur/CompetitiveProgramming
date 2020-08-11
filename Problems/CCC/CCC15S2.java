package Problems.CCC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CCC15S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int j = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int total = 0;

        Map<Character, Integer> sizeConvert = new HashMap<>();
        sizeConvert.put('S', 0);
        sizeConvert.put('M', 1);
        sizeConvert.put('L', 2);

        int[] jerseys = new int[j+1];

        for (int i = 1; i <= j; i++) {
            char size = br.readLine().charAt(0);
            jerseys[i] = sizeConvert.get(size);
        }

        for (int i = 0; i < a; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int size = sizeConvert.get(st.nextToken().charAt(0));
            int number = Integer.parseInt(st.nextToken());

            if(1<=number && number <= j &&jerseys[number] >= size) {
                total++;
                jerseys[number] = -1;
            }
        }

        System.out.println(total);

    }
}
