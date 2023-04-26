package Problems.DmoJ;

import java.util.*;
import java.io.*;

public class USACO2018DP1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    static int n, m, c;
    static int[] arr;
 
 
    public static void main(String[] args) throws IOException{
        n = readInt();
        m = readInt();
        c = readInt();

        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = readInt();
        }

        Arrays.sort(arr);


        int high = arr[arr.length - 1];
        int low = 0;
        int prev = -1;

        while(low < high){
            int mid = (high + low)/2;
            if(mid == prev) break;
            boolean tooLittleTime = simulation(mid, m);

            if(tooLittleTime){
                high = mid;
            }else{
                low = mid;
            }
            prev = mid;
        }

        if(simulation(high, m)){
            System.out.println(high);
        }else{
            System.out.println(low);
        }
    }

    private static boolean simulation(int time, int m){
        int curLow = arr[0];
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] - curLow > time || count == c){
                curLow = arr[i];
                m--;
                count = 0;
            }
            count ++;
        }

        m--;
        // System.out.println("The result of simulation on time interval " + time + " is " + (m >= 0?"true":"false"));

        if (m < 0) {
            return false;
        }
        return true;
        
    }
 
 
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}