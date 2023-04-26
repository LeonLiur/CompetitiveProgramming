package Problems.DMOPC;

import java.util.*;
import java.io.*;

public class DMOPC21C2P1{  

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

    static int time;
    static int N, H, P;
    static int[] diff;
    static int[] dp;

	public static void main(String[] args) throws IOException{
        
        N = readInt();
        H = readInt();
        P = readInt();

        diff = new int[N];

        for(int i = 0; i < N; i++){
            diff[i] = readInt();
        }

        dp = new int[N];
        
        System.out.println(dpr(0,0,0));

        
	}
    
    private static int dpr(int level, int power, int time){
        // System.out.println("current time needed:" + time);
        // System.out.println("current level: " + level);
        // System.out.println("---");
        if(level == N ){
            return time;
        }

        if(dp[level] != 0){
            return dp[level];
        }

        if(power >= diff[level]){
            return time + dpr(level + 1, power, time);
        }
        
        return dp[level] = Math.min(dpr(level + 1, diff[level], time + (diff[level] - power) * H),
        dpr(level + 1, power, time + (diff[level] - power) * P));

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