package Problems.CCC;

import java.io.*;
import java.util.*;

public class CCC13S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    private static int[][] matches;
    private static int[][] outcomes = {{0, 3}, {1, 1}, {3, 0}};
    private static int T;
    private static int G;
    private static boolean[][] fought = new boolean[5][5];
    private static int[] score = new int[5];
    private static int count;

    private static void recursion(int counter){
        if(counter == 6 - G){
            int max = 0;
            int maxIndex = -1;
            boolean tie = false;
            for(int i = 1; i < 5; i++){
                if(score[i] > max){
                    max = score[i];
                    maxIndex = i;
                    tie = false;
                }else if(score[i] == max){
                    tie = true;
                }
            }


            if(!tie && T == maxIndex){
                count ++;
            }
            return;
        }

        for (int[] outcome : outcomes) {
            score[matches[counter][0]] += outcome[0];
            score[matches[counter][1]] += outcome[1];

            recursion(counter + 1);

            score[matches[counter][0]] -= outcome[0];
            score[matches[counter][1]] -= outcome[1];
        }
        
    }

 
    public static void main(String[] args) throws IOException{
        T = readInt();
        G = readInt();
        matches = new int[6 - G][2];

        for(int i = 0; i < G; i++){
            int teamA = readInt();
            int teamB = readInt();
            int scoreA = readInt();
            int scoreB = readInt();

            fought[teamA][teamB] = true;
            fought[teamB][teamA] = true;
            
            if(scoreA > scoreB){
                score[teamA] += 3;
            }else if(scoreB > scoreA){
                score[teamB] += 3;
            }else{
                score[teamA] += 1;
                score[teamB] += 1;
            }
        }

        int counter = 0;
        for(int i = 1; i < 5; i++){
            for(int j = 1; j < 5; j++){
                if(i == j)   continue;
                if(!fought[i][j]){
                    fought[j][i] = true;
                    int[] temp = {i, j};
                    matches[counter] = temp;
                    counter ++;
                }
            }
        }
        
        // for (int[] match : matches) {
        //     System.out.println(match[0] +  " - " + match[1]);
        // }

        recursion(0);

        System.out.println(count);
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
