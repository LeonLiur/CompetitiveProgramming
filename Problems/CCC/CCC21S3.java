package Problems.CCC;

import java.util.*;
import java.io.*;

public class CCC21S3{
    static int[][] friendInfo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        // System.out.println(N);
        friendInfo = new int[N][3];
        
        int low = Integer.MAX_VALUE;
        int high = 0;

        for(int i = 0; i < N; i++){
            // System.out.println(i);
            st = new StringTokenizer(br.readLine());
            friendInfo[i][0] = Integer.parseInt(st.nextToken());
            friendInfo[i][1] = Integer.parseInt(st.nextToken());
            friendInfo[i][2] = Integer.parseInt(st.nextToken());
            low = Math.min(low, friendInfo[i][0]);
            high = Math.max(high, friendInfo[i][0]);
        }

        int mid = 0;
        long result = 0;

        while(low <= high){
            mid = (low+high)/2;
            result = f(mid);
            long resultRight = f(mid + 1);
            long resultLeft = f(mid - 1);

            if(result < resultRight && result < resultLeft){
                break;
            }
            if(result == resultRight || result == resultLeft){
                break;
            }

            if(result < resultRight){
                high = mid - 1;
            }else if(result < resultLeft){
                low = mid + 1;
            }
        }

        System.out.println(result);
        
    }

    private static long f(int pos){
        long sum = 0;
        for (int[] is : friendInfo) {
            long dist = Math.abs(is[0] - pos) - is[2];
            if(dist > 0){
                sum += is[1] * dist;
            }
        }

        return sum;
    }
}