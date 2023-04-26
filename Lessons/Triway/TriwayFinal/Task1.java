package Problems.TriwayFinal;

import java.util.Scanner;
import java.util.TreeSet;

public class Task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> myTree = new TreeSet<>();
        while(true){
            int x = sc.nextInt();
            if(myTree.contains(x)){
                break;
            }
            myTree.add(x);
        }
        System.out.println(myTree.size());
    }



}
