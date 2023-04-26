package Problems.TriwayFinal;

import java.util.HashMap;
import java.util.Map;

public class Task8 {
    public static void main(String[] args) {
        HashMap<String, String> myMap = new HashMap<>();
        myMap.put("A", "apple");
        myMap.put("B", "banana");
        myMap.put("C", "carrot");
        myMap.put("D", "dragonfruit");
        myMap.put("E", "eggplant");

        for (Map.Entry<String, String> set : myMap.entrySet()) {
            System.out.println(set.getKey() + " = " + set.getValue());
        }
    }
}
