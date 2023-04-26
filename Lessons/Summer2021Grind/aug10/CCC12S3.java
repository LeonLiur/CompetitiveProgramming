package Summer2021.aug10;

import java.util.*;

public class CCC12S3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        TreeMap<Integer, Integer> myTree = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            int reading = sc.nextInt();
            if(!myTree.containsKey(sc.nextInt())){
                myTree.put(reading, 1);
            }else{
                int oldval = myTree.get(reading);
                myTree.replace(reading, oldval, oldval+1);
            }
        }

        System.out.println("sdfasfd");
        for (int i = 0; i < myTree.size(); i++) {
            System.out.println("key: " + i);
            System.out.println("value: " + myTree.get(i));
        }
//        int highestfq = 0;
//        ArrayList<Integer> harr = new ArrayList<>();
//        int secondhighestfq = 0;
//
//        for (int i = 1; i < 1001; i++) {
//            if(arr[i] > highestfq){
//                harr.clear();
//                highestfq = arr[i];
//                harr.add(i);
//            }else if(arr[i] == highestfq){
//                harr.add(i);
//            }
//        }
    }
}
