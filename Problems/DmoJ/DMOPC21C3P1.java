package Problems.DmoJ;

import java.util.*;
import java.io.*;
public class DMOPC21C3P1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;



    private static boolean isIn(long x1, long y1, long x2, long y2, long x, long y){
        // System.out.printf("checking if %s, %s is in %s, %s | %s, %s | %s, %s || ", x, y, x1, y1, x1, y2, x2, y1);
        long area = Math.abs(x1 - x2) * Math.abs(y1 - y2);
        if((x >= x1 && x <= x2) || (x <= x1 && x >= x2)){
            if((y >=y1 && y <= y2) || (y <= y1 && y >= y2)){
                long areaA = Math.abs(y1 - y2) * Math.abs(x - x1);
                long areaB = Math.abs(y - y1) * Math.abs(x1 - x2);
                // System.out.printf("result is %s\n", areaA + areaB);
                if(areaA + areaB <= area){
                    return true;
                }
            }
        }
        return false;
    }
 
    public static void main(String[] args) throws IOException{
        int N, Q;
        long x1, x2, x3, y1, y2, y3;
        N = readInt();
        Q = readInt();
        long[][] store = new long[N][4];
        for(int i = 0; i < N; i++){
            x1 = readInt();
            y1 = readInt();
            x2 = readInt();
            y2 = readInt();
            x3 = readInt();
            y3 = readInt();
            
            store[i][0] = x1;
            store[i][1] = y1;
            store[i][2] = x3;
            store[i][3] = y2;
        }

        for(int i = 0; i < Q; i++){
            long x = readInt();
            long y = readInt();
            long counter = 0;
            for (int j = 0; j < store.length; j++) {
                if(isIn(store[j][0], store[j][1], store[j][2], store[j][3], x, y)){
                    counter++;
                }
            }
            System.out.println(counter);
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