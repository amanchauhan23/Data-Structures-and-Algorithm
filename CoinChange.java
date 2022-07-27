// #1 Plain Recursion
class Solution {
    
    public int coinChange(int[] coins, int amount) {
        int ans = (int)rec(coins, amount);
        if(ans == Integer.MAX_VALUE)
            return -1;
        return (int)rec(coins, amount);
    }
    
    public long rec(int[] coins, int n){
        if(n == 0)
            return 0;
        if(n < 0)
            return Integer.MAX_VALUE;
        long ans = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            ans = Math.min(rec(coins, n - coins[i]) + 1, ans);
        }
        return ans;
    }
}


// #2 using memoization
class Solution {
    long memo[];
    public int coinChange(int[] coins, int amount) {
        memo = new long[amount + 1];
        int ans = (int)dfs(coins, amount);
        return ans < 0? -1:ans;
    }
    
    public long dfs(int coins[], int rem){
        if(rem < 0)
            return Integer.MAX_VALUE;
        if(rem == 0)
            return 0;
        if(memo[rem] == 0){
            long ans = Long.MAX_VALUE;
            for(int i = 0; i < coins.length; i++){
                ans = Math.min(dfs(coins, rem - coins[i]) + 1, ans);
            }
            memo[rem] = ans;
        }
        return memo[rem];
    }
}

// #3 Tabulation
class Solution {
    public int coinChange(int[] coins, int amount) {
        long dp[] = new long[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;
        
        for(int i = 1; i <= amount; i++){
            for(int j = 0;  j < coins.length; j++){
                if(i - coins[j] >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        if(dp[amount] >= Integer.MAX_VALUE)
            return -1;
        return (int)dp[amount];
    }
}
