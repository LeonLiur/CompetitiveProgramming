package Triway.SeriousTriway.DP;

public class knapsackTEST {


    // Returns the maximum value that can
    // be put in a knapsack of capacity W
    static long knapSack(int W, int[] wt,
                        int[] val, int n)
    {
        int i, w;
        long[][] K = new long[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n ; i++)
        {
            for (w = 0; w <= W ; w++)
            {
                if(w ==0 || i == 0){
                    K[i][w] = 0;
                }
                else if (wt[i] <= w)
                    K[i][w]
                            = Math.max(val[i]
                                    + K[i-1][w - wt[i]],
                            K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }

        return K[n][W];
    }

    // Driver code
    public static void main(String[] args)
    {
        int[] val = new int[] {0, 5, 6, 4, 6, 5, 2};
        int[] wt = new int[] {0, 6, 5, 6, 6, 3, 7 };
        int W = 15;
        int n = 6;
        System.out.println(knapSack(W, wt, val, n));
    }
}

