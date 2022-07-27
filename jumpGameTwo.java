// #1 Plain Recursion
class Solution {
    public int jump(int[] nums) { //O(n^n)
        return rec(nums, 0);
    }
    
    int rec(int nums[], int i){
        if(i == nums.length - 1)
            return 0;
        if(i >= nums.length)
            return 1000000;
        
        int jump = nums[i];
        int ans = 1000000;
        for(int j = 1; j <= jump; j++){
            if(i + j < nums.length)
                ans = Math.min(ans, rec(nums, i + j) + 1);
        }
        return ans;
        
    }
}

// #2 Recursion from right to left
class Solution {
    public int jump(int[] nums) {      
        return j(nums, nums.length);
    }
    
    public int j(int []nums, int n){
        if(n == 1)
            return 0;
        
        int res = Integer.MAX_VALUE;
        
        for(int i = 0; i <= n - 2; i++){
            if(i + nums[i] >= n - 1){
                int sub_res = j(nums, i + 1);
                if(sub_res != Integer.MAX_VALUE)
                    res = Math.min(res, sub_res + 1);
            }
        } 
        return res;
    }
}

// #3 Memoization + rec
class Solution {                  // O(n^2) | O(n)
    public int jump(int[] nums) {
        int memo[] = new int[nums.length + 1];
        return rec(nums, memo, 0);
    }
    
    int rec(int nums[], int memo[], int i){
        if(i == nums.length - 1)
            return 0;
        if(i >= nums.length)
            return 1000000;
        
        if(memo[i] != 0)
            return memo[i];
        
        int jump = nums[i];
        int ans = 1000000;
        for(int j = 1; j <= jump; j++){
            if(i + j < nums.length)
                ans = Math.min(ans, rec(nums, memo, i + j) + 1);
        }
        return memo[i] = ans;
        
    }
    
}

// #4 Tabulation
class Solution {
    public int jump(int[] nums) {  // O(n2) || O(n)
        
        int dp[] = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                if(j + nums[j] >= i)
                    if(dp[j] != Integer.MAX_VALUE)
                        dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[nums.length - 1];
    }
}

// #5 Efficient || Greedy Algo || o(n)
class Solution {
    public int jump(int[] nums) {     
        
        int l = 0;
        int r = 0;
        int min = 0;
        
        while(r < nums.length - 1){
            
            int tempR = r;
            
            for(int i = l; i <= r; i++){
                tempR = Math.max(tempR, i + nums[i]);
            }
            
                l = r + 1;
                r = tempR;
                min++;

        }
        return min;
    }
    
}
