// #1 Plain Recursive
class Solution {
    public boolean canJump(int[] nums) {
        int ans = jumpREC(nums, 0);
        if(ans == Integer.MAX_VALUE)
            return true;
        return false;
    }
    
    public int jumpREC(int nums[], int i){
        if(i == nums.length - 1)
            return Integer.MAX_VALUE;
        if(i >= nums.length)
            return Integer.MIN_VALUE;
        int jumps = nums[i];
        for(int j = 1;j <= jumps; j++){
            if(i + j < nums.length){
                int ans = jumpREC(nums, i + j);
                if(ans == Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            }
        }
        return Integer.MIN_VALUE;
    }
}

// #2 Recursion + Memoization
class Solution {
    public boolean canJump(int[] nums) { 
        int memo[] = new int[nums.length];
        int ans = jumpMEMO(nums, memo, 0);
        if(ans == Integer.MAX_VALUE)
            return true;
        return false;
    }
 
    public int jumpMEMO(int nums[], int memo[], int i){
        if(i == nums.length - 1)
            return Integer.MAX_VALUE;
        if(i >= nums.length)
            return Integer.MIN_VALUE;
        
        if(memo[i] != 0)
            return memo[i];
        
        int jumps = nums[i];
        for(int j = 1; j <= jumps; j++){
            if(i + j < nums.length){
                int ans = jumpMEMO(nums, memo, i + j);
                if(ans == Integer.MAX_VALUE)
                    return memo[i] = ans;
            }
        }
        return memo[i] = Integer.MIN_VALUE;
    }
}


// #3 Greedy Algorithm | shifting goal towards left, in every iteration if possible
class Solution {
    public boolean canJump(int[] nums) { // O(n)
        
        int goal = nums.length - 1;
        
        for(int i = nums.length - 1; i >= 0; i--)
            if(i + nums[i] >= goal)
                goal = i;
        
        return goal == 0;
    }
}
