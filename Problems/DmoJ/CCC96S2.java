package Problems.DmoJ;

import java.util.Scanner;

public class CCC96S2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            String og = sc.next();
            System.out.println(og);
            int digits = og.length();
            int[] number = new int[digits];

            int counter = 0;
            for (char j : og.toCharArray()) {
                number[counter] = Character.getNumericValue(j);
                counter += 1;
            }

            while(digits > 2){        
                int unit = number[digits - 1];
                int minus = 0;
                digits -= 1;
                boolean overflow = number[digits - 1 - minus] < unit;
                if(overflow){
                    number[digits - 1] += 10 - unit;
                    while(true){
                        if(number[digits - 2 - minus] != 0){
                            number[digits - 2 - minus] -= 1;
                            break;
                        }else{
                            number[digits - 2 - minus] = 9;
                            minus += 1;
                        }
                    }
                }else{
                    number[digits - 1 - minus] -= unit;
                }

                // check for leading zeroes
                int count = 0;
                int zeroCount = 0;
                while(number[count] == 0){
                    zeroCount += 1;
                    count++;
                }
                if(zeroCount != 0){
                    digits -= zeroCount;
                    for(int m = 0; m < number.length - zeroCount; m++){
                        number[m] = number [m + zeroCount];
                    }
                }
    

               for (int j = 0; j < digits - 1; j++) {
                   System.out.print(number[j]);
               }
               System.out.println(number[digits - 1]);
            }
            int res = digits == 1?number[0] : number[0] * 10 + number[1];
            System.out.println(res%11 == 0?"The number " + og + " is divisible by 11.":"The number " + og + " is not divisible by 11.");
            if(i != n - 1){
                System.out.println();
            }
        }
    }
}
