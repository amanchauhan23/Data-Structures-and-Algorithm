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

// #3 Tabulation


// #4 optimized binary search + memo ||| Accepted
class Solution { // O(k*NlogN) || O(kN)
    int memo[][];
    public int superEggDrop(int k, int n) {
        memo = new int[k+1][n+1];
        return egg(k,n);
    }
    
    public int egg(int k, int n){
        if(n == 0)
            return 0;
        if(k == 1)
            return n;
        
        int low = 1;
        int high = n;
        
        if(memo[k][n] != 0)
            return memo[k][n];
        
        int ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = (low + high)/2;
            int tone = egg(k-1, mid-1);
            int ttwo = egg(k, n-mid);
            
            if(tone < ttwo){
                low = mid + 1;
                ans = Math.min(ttwo + 1, ans);
            }else if(tone > ttwo){
                high = mid - 1;
                ans = Math.min(tone + 1, ans);
            }else{
                ans = Math.min(ttwo + 1, ans);
                break;
            }
        }
        memo[k][n] = ans;
        return memo[k][n];
    }
}
