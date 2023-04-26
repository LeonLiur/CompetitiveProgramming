package Problems.DmoJ;

import java.util.*;
import java.io.*;

public class DMPG17G2 {
    static long[] arr = new long[2000000];
    static long[] lazy = new long[1000000];
    static long[] segTree = new long[1000000];
    public static void main(String[] args) throws IOException{
        long m = readLong();
        int n = readInt();
        int q = readInt();

        for(int i = 0; i < n; i++){
            arr[i] = readLong();
        }

        // building segtree
        build(0, n-1, 1);
        for(int i = 0; i < q; i++){
            int c = readInt();
            if(c == 1){
                update(readInt() - 1, readInt() - 1, 0, n-1, readLong(), 1);
            }else{
                System.out.println(sum(readInt() - 1, readInt() - 1, 0, n - 1, 1) % m);
            }
        }
        
    }
    
    private static void build(int l, int r, int index){
        if(l == r){
            segTree[index] = arr[l];
            return;
        }
        
        int mid = (l+r) / 2;
        build(l, mid, index * 2);
        build(mid + 1, r, index * 2 + 1);

        segTree[index] = segTree[index * 2] + segTree[index * 2 + 1];
    }

    private static void update(int x, int y, int l, int r, long val, int index){
        // Pushing down:
        if(lazy[index] != 0){
            segTree[index] += (r - l + 1) * lazy[index];
            if(l != r){
                lazy[index *2] += lazy[index];
                lazy[index * 2 + 1] += lazy[index];
            }
            lazy[index] = 0;
        }

        // case 1
        if(x > r || r < l || y < l){
            return;
        }

        // case 2
        if(x <= l && y >= r){
            segTree[index] += (r - l + 1) * val;
            if(l != r){
                lazy[index * 2] += val;
                lazy[index * 2 + 1] += val;
            }
            return;
        }

        int mid = (l + r) / 2;
        update(x, y, l, mid, val, index * 2);
        update(x, y, mid + 1, r, val, index * 2 + 1);

        segTree[index] = segTree[index * 2] + segTree[index * 2 + 1];    
    }

    private static long sum(int x, int y, int l, int r, int index){
        if(y < l || x > r || r < l){
            return 0;
        }

        if(lazy[index] != 0){
            segTree[index] += (r - l + 1) * lazy[index]; 
            // push down:
            if (l != r) {
                lazy[index * 2] += lazy[index];
                lazy[index * 2 + 1] += lazy[index];
            }
            lazy[index] = 0;
        }

        // case 2
        if(x <= l && y >= r){
            return segTree[index];
        }

        int mid = (l+r) / 2;
        long long1 = sum(x, y, l, mid, index * 2);
        long long2 = sum(x, y, mid + 1, r, index * 2 + 1);
        return long1 + long2;
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

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
