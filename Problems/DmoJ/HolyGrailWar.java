package Problems.DmoJ;

import java.util.*;
import java.io.*;

/**
 * problem: HolyGrailWar date: Sat Nov 20 2021
 */
public class HolyGrailWar {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    static class Node{
        long sum, prefix, suffix, max, maxV;
    }
    static int MN = 100005;

    static int n, q, u, v;
    static long[] arr = new long[MN];
    static char c;
    static Node[] segTree = new Node[MN * 3];

    private static Node compute(Node x, Node y){
        Node ret = new Node();
        ret.sum = x.sum + y.sum;
        ret.prefix = Math.max(x.prefix, x.sum + y.prefix);
        ret.suffix = Math.max(y.suffix, y.sum + x.suffix);
        ret.max = Math.max(x.suffix + y.prefix, Math.max(x.max, y.max));
        ret.maxV = Math.max(x.maxV, y.maxV);
        return ret;
    }

    private static void build(int l, int r, int index){
        if(l == r){
            segTree[index].sum = arr[l];
            segTree[index].prefix = Math.max(0l, arr[l]);
            segTree[index].suffix = Math.max(0l, arr[l]);
            segTree[index].max = Math.max(0l, arr[l]);
            segTree[index].maxV = arr[l];
            return;
        }
        int mid = (l+r) >> 1;
        build(l, mid, index * 2);
        build(mid + 1, r, index * 2 + 1);
        segTree[index] = compute(segTree[index * 2], segTree[index * 2 + 1]);
    }

    private static void update(int l, int r, int x, long val, int index){
        if(l == r){
            segTree[index].sum = val;
            segTree[index].prefix = Math.max(0l, val);
            segTree[index].suffix = Math.max(0l, val);
            segTree[index].max = Math.max(0l, val);
            segTree[index].maxV = val;
            return;
        }
        int mid = (l+r) >> 1;
        if (x > mid) update(mid + 1, r, x, val, index * 2 + 1);
        else update(l, mid, x, val, index * 2);
        segTree[index] = compute(segTree[index * 2], segTree[index * 2 + 1]);
    }

    private static Node query(int l, int r, int x, int y, int index){
        if(r < x || l > y || r < l) {
            
        }

        return new Node();
    }

    public static void main(String[] args) throws IOException {
        
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}