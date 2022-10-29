// #1 Recursion
class Solution // O(2^N)
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        if(W == 0 || n == 0)  return 0;
         
        if(wt[n-1] > W)
            return knapSack(W, wt, val, n - 1);
        else
            return Math.max(knapSack(W - wt[n-1], wt, val, n - 1) + val[n-1], knapSack(W, wt, val, n - 1));
    } 
}

// #2 Recursion + Memoization
class Solution // O(W*n) || O(W*n)
{ 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        
        int[][] memo = new int[W + 1][n + 1];
        return knap(W, wt, val, memo, n);
         
    } 
    
    public static int knap(int W, int wt[], int val[], int [][]memo, int n){
        
        if(W == 0 || n == 0)  return 0;
        
        if(memo[W][n] != 0)
            return memo[W][n];
            
        if(wt[n-1] > W)
            memo[W][n] = knap(W, wt, val, memo, n - 1);
        else
            memo[W][n] = Math.max(knap(W - wt[n-1], wt, val, memo, n - 1) + val[n-1], knap(W, wt, val, memo, n - 1));
        
        return memo[W][n];
    }
    
}

// #3 Tabulation || optimized
class Solution // O(W*n) || O(W*n)
{ 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        
        int[][] dp = new int[n+1][W+1];
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= W; j++){
                if(wt[i-1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
            }
        }
        return dp[n][W];
    } 
}
