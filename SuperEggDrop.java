// #1  Plain Recursion
class Solution {
    public int superEggDrop(int k, int n) {
        return mTrial(n, k);
    }
    
    public int mTrial(int n, int e){
        if(e == 1)
            return n;
        if(n == 1) 
            return 1;
        if(n == 0)
            return 0;
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            int res = Math.max(mTrial(i - 1, e - 1), mTrial(n - i, e));
            min = Math.min(min, res);
        }
        return min + 1;
    }
}

// #2 || Memoization
class Solution {
    int memo[][];
    public int superEggDrop(int k, int n) {
        memo = new int[n + 1][k + 1];
        return mTrial(n, k);
    }
    
    public int mTrial(int n, int e){
        if(e == 1)
            return n;
        if(n == 1) 
            return 1;
        if(n == 0)
            return 0;
        
        if(memo[n][e] != 0)
            return memo[n][e];
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            int res = Math.max(mTrial(i - 1, e - 1), mTrial(n - i, e));
            min = Math.min(min, res);
        }
        return memo[n][e] = min + 1;
    }
    
}
