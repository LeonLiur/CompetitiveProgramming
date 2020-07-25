package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CCC16S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String src = sc.nextLine();

        List<Character> characterList = new ArrayList<>();

        for (Character x: src.toCharArray()
             ) {
            characterList.add(x);
        }

        String dest = sc.nextLine();
        List<Character> destList = new ArrayList<>();
        int astCounter = 0;

        for (Character x: dest.toCharArray()
        ) {
            destList.add(x);
            if(x == '*'){
                astCounter++;
            }
        }

        for (Character y: destList
             ) {
            if(characterList.contains(y)){
                characterList.remove(y);
            }else{
                if(astCounter > 0){
                    astCounter--;
                }else{
                    System.out.println("N");
                    System.exit(0);
                }
            }
        }

        System.out.println("A");
    }
}
