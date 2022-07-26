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
            long ans = Long.MAX_VALUE;;
            for(int i = 0; i < coins.length; i++){
                ans = Math.min(dfs(coins, rem - coins[i]) + 1, ans);
            }
            memo[rem] = ans;
        }
        return memo[rem];
    }
}
