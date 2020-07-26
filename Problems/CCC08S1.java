package Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class CCC08S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st;

        TreeMap<Integer,String> myMap = new TreeMap<>();
        String name;
        int temp;

        while (true){
            st = new StringTokenizer(line);
            name = st.nextToken();
            temp = Integer.parseInt(st.nextToken());
            myMap.put(temp, name);
            if(name.equals("Waterloo")){
                break;
            }
            line = br.readLine();
        }

        System.out.println(myMap.firstEntry().getValue());
    }
}
