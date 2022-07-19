// #1 
class Solution {
    public int lengthOfLIS(int[] nums) {
        return rec(nums, 0, Integer.MIN_VALUE);
    }
    
    int rec(int []nums, int i, int max){ 
        if(i == nums.length)
            return 0;
        int max1 = 0, max2 = 0;
        if(max < nums[i]){
            max1 = rec(nums, i + 1, nums[i]) + 1;
        }
        max2 = rec(nums, i + 1, max);
        return Math.max(max1, max2);
    }
}

// #2 
class Solution {
    public int lengthOfLIS(int[] nums) { // O(N^2) | O(N)
        int lis[] = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            lis[i] = 1;
            for(int j = i - 1; j >= 0; j--){
                if(nums[j] < nums[i])
                    lis[i] = Math.max(lis[j] + 1, lis[i]);
            }
        }
        
        int ans = 0;
        for(int i: lis)
            ans = Math.max(ans, i);
        return ans;
    }
}


// #3
class Solution {
    public int lengthOfLIS(int[] nums) { // O(N) | O (N) || Binary Search
        if(nums.length == 0)
            return 0;
        List<Integer> ls = new ArrayList<>();
        ls.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > ls.get(ls.size() - 1)){
                ls.add(nums[i]);
            }else{
                int index = Collections.binarySearch(ls, nums[i]);
                if(index < 0)
                    index = Math.abs(index) - 1;
                ls.set(index, nums[i]);
            }
        }
        return ls.size();
    }
}
