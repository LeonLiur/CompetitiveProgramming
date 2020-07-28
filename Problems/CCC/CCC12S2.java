package Problems.CCC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CCC12S2 {
    private static final Map<Character, Integer> romanMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        initData();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();

        char r1;
        int a1;
        char r2 = 0;
        int a2 = 0;

        int sum = 0;

        a1 = Integer.parseInt(line.substring(0,1));
        r1 = line.charAt(1);
        for (int i = 2; i < line.length(); i += 2) {
            a2 = Integer.parseInt(line.substring(i,i + 1));
            r2 = line.charAt(i + 1);

            sum += romanMap.get(r2) > romanMap.get(r1) ? -a1 * romanMap.get(r1) : a1 * romanMap.get(r1);

            a1 = a2;
            r1 = r2;
        }
        sum += romanMap.get(r2) * a2;

        System.out.println(sum);

    }

    private static void initData() {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }
}
