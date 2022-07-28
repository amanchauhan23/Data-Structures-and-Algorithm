// #1 Recursion 
class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int arr[], int n)
    {
        
        return sol(arr, 0, arr.length - 1);
        
    }
    
    public static long sol(int arr[], int i, int j){
        
        if(i + 1 == j)
            return Math.max(arr[i], arr[j]);
        
        long res = Math.max(arr[i] + Math.min(sol(arr, i + 2, j), sol(arr, i + 1, j - 1)), 
                            arr[j] + Math.min(sol(arr, i + 1, j - 1), sol(arr, i, j - 2)));
        
        return res;
    }
}

// #2 Recursion + Memoization
class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int arr[], int n)
    {
        long memo[][] = new long[arr.length][arr.length];
        return sol(arr, memo, 0, arr.length - 1);
        
    }
    
    public static long sol(int arr[], long[][] memo, int i, int j){
        
        if(i+1 == j)
            return Math.max(arr[i], arr[j]);
        
        if(memo[i][j] != 0)
            return memo[i][j];
        return memo[i][j] = Math.max(arr[i] + Math.min(sol(arr, memo, i + 2, j), sol(arr, memo, i + 1, j - 1)), 
                            arr[j] + Math.min(sol(arr, memo, i + 1, j - 1), sol(arr, memo, i, j - 2)));
    }
}

// #3 Tabulation // O(n2) || O(n2)
class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int arr[], int n)
    {
        int [][]dp = new int[n][n];
        
        for(int i = 0; i < n - 1; i++)
            dp[i][i+1] = Math.max(arr[i], arr[i+1]);
        
            for(int gap = 3; gap < n; gap+=2){
                for(int i = 0; i + gap < n; i++){
                    int j = i+gap;
                    dp[i][j] = Math.max(arr[i] + Math.min(dp[i+2][j], dp[i+1][j-1]),
                                        arr[j] + Math.min(dp[i+1][j-1], dp[i][j-2]));
                }
            }
            return dp[0][n-1];
        
        
        
    }
}
