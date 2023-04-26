package Problems.DmoJ;

import java.util.*;

public class FHC2015R2P2{

    static Deque<Integer> dqc;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++){
            int N = sc.nextInt();
            dqc = new LinkedList<>();

            for(int j = 0; j < N; j++){
                dqc.add(sc.nextInt());
            }

            boolean result1 = check1();
            boolean result2 = check2();

            
            System.out.println((result1 || result2)?"Case #" + (i+1) + ": yes":"Case #" + (i+1) + ": no");
        }
    }

    private static boolean check1(){
        Deque<Integer> dq2 = new LinkedList<>();
        Deque<Integer> dq = new LinkedList<>();
        for (Integer integer : dqc) {
            dq.add(integer);
        }

            dq2.add(dq.pollFirst());
            int highPointer = dq2.peekLast();
            int lowPointer = dq2.peekFirst();
            boolean result = true;

            while(!dq.isEmpty()){
                if(dq.peekFirst() == highPointer + 1){
                    dq2.addLast(dq.pollFirst());
                    highPointer ++;
                }else if(dq.peekFirst() == lowPointer - 1){
                    dq2.addFirst(dq.pollFirst());
                    lowPointer --;
                }else if(dq.peekLast() == highPointer + 1){
                    dq2.addLast(dq.pollLast());
                    highPointer ++;
                }else if(dq.peekLast() == lowPointer - 1){
                    dq2.addFirst(dq.pollLast());
                    lowPointer --;
                }else{
                    return false;
                }
            }
            return true;
    }

    private static boolean check2(){
        Deque<Integer> dq2 = new LinkedList<>();
        Deque<Integer> dq3 = new LinkedList<>();
  
        for (Integer integer : dqc) {
            dq3.add(integer);
        }

            dq2.add(dq3.pollLast());
            int highPointer = dq2.peekLast();
            int lowPointer = dq2.peekFirst();

            while(!dq3.isEmpty()){
                if(dq3.peekFirst() == highPointer + 1){
                    dq2.addLast(dq3.pollFirst());
                    highPointer ++;
                }else if(dq3.peekFirst() == lowPointer - 1){
                    dq2.addFirst(dq3.pollFirst());
                    lowPointer --;
                }else if(dq3.peekLast() == highPointer + 1){
                    dq2.addLast(dq3.pollLast());
                    highPointer ++;
                }else if(dq3.peekLast() == lowPointer - 1){
                    dq2.addFirst(dq3.pollLast());
                    lowPointer --;
                }else{
                    return false;
                }
            }
            return true;
    }
    
}