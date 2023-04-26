package Problems.DmoJ;
// package Problems.DmoJ;

// import java.util.*;
// import java.io.*;
// public class DP1 {
//     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//     static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//     static StringTokenizer st;
 
 
//     public static void main(String[] args) throws IOException{
//         String a = next();
//         short x = readShort();
//         TreeMap<Integer, String> tm = new TreeMap<>();
//         while(!(a.equals("Waterloo"))){
//           tm.put(x,a);
//           a = next();
//           x = readShort();
//         }
//         System.out.println(tm.firstKey());
//     }
 
 
//     static String next () throws IOException {
//         while (st == null || !st.hasMoreTokens())
//             st = new StringTokenizer(br.readLine().trim());
//         return st.nextToken();
//     }
//     static long readLong () throws IOException {
//         return Long.parseLong(next());
//     }
//     static int readInt () throws IOException {
//         return Integer.parseInt(next());
//     }
//     static double readDouble () throws IOException {
//         return Double.parseDouble(next());
//     }
//     static char readCharacter () throws IOException {
//         return next().charAt(0);
//     }
//     static String readLine () throws IOException {
//         return br.readLine().trim();
//     }
// }