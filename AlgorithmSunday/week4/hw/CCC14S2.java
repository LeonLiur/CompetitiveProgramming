package week4.hw;

import java.util.*;

public class CCC14S2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<String> firstRow = new ArrayList<>();
        List<String> secondRow = new ArrayList<>();

        for (int i = 0; i < 2*n; i++) {
            if(i<n){
                firstRow.add(sc.next());
            }else{
                secondRow.add(sc.next());
            }
        }

        Map<String, String> partnerMap = new HashMap<>();
        for (int i = 0; i < firstRow.size(); i++) {
            if(firstRow.get(i).equals(secondRow.get(i))){
                System.out.println("bad");
                System.exit(0);
            }
            partnerMap.put(firstRow.get(i), secondRow.get(i));
        }

        for (String topName : firstRow) {
            String buttomName = partnerMap.get(topName);
            String topFromButtom = partnerMap.get(buttomName);

            if (!topName.equals(topFromButtom)) {
                System.out.println("bad");
                System.exit(0);
            }
        }

        System.out.println("good");
    }
}
