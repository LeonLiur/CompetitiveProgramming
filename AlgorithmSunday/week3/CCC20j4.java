package week3;

import java.util.Scanner;

public class CCC20j4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String out = sc.nextLine();

        if(checkShift(in,out)){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
    private static boolean checkShift(String in, String out){
        String shift;
        for(int i=0;i<in.length()-1;i++){
            shift = in.substring(i+1);
            shift = shift + in.substring(i, i+1);

            if(out.contains(shift)){
                return true;
            }
        }
        return false;
    }
}