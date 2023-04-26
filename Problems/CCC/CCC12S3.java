package Problems.CCC;

import java.util.*;
import java.io.*;
public class CCC12S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    static class Reading implements Comparable<Reading>{
        int reading;
        int freq = 0;

        void addFreq(){
            this.freq++;
        }

        Reading(int reading){
            this.reading = reading;
        }

        @Override
        public int compareTo(Reading o) {
            return this.freq - o.freq;
        }

        @Override
        public String toString(){
            return "reading: " + reading + " -- " + "freq: " + freq;
        }
    }
 

    public static void main(String[] args) throws IOException{
        int N = readInt();

        Reading[] arr = new Reading[1001];
        for(int i = 0; i < 1001; i++){
            arr[i] = new Reading(i);
        }

        for(int i = 0; i < N; i++){
            arr[readInt()].addFreq();
        }


        Arrays.sort(arr);

        // for (Reading reading : arr) {
        //     System.out.println(reading);
        // }

        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();

        int highestFreq = arr[1000].freq;
        int counter = 1000;
        Reading cur = arr[counter];
        while(cur.freq == highestFreq && counter != 0){
            al1.add(cur.reading);
            cur = arr[--counter];
        }
        if(counter != 0){
            highestFreq = arr[counter].freq;
            while(cur.freq == highestFreq && counter != 0){
                al2.add(cur.reading);
                cur = arr[--counter];
            }
        }

        Collections.sort(al1);
        Collections.sort(al2);
        
        if(al1.size() == 1 && al2.size() > 1){
            System.out.println(Math.max(Math.abs(al2.get(al2.size() - 1) - al1.get(0)), Math.abs(al1.get(al1.size() - 1) - al2.get(0))));
        }else if(al1.size() > 1){
            System.out.println(Math.abs(al1.get(al1.size() - 1) - al1.get(0)));
        }else if(al1.size() == 1 && al2.size() == 1){
            System.out.println(Math.abs(al1.get(0) - al2.get(0)));
        }
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