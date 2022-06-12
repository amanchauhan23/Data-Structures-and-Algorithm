class Solution {
    public int minOperations(int[] nums, int x) { // O(n) | O(1)
        int max = -1;
        int l =0 ;
        int r =0;
        int sum = 0;
        for(int s : nums)
            sum+=s;
        int currentSum =0;
        while(r<nums.length){
            currentSum += nums[r];
                while(l<=r && currentSum > sum - x)
                    currentSum -= nums[l++];
            if(currentSum == sum - x)
                max = Math.max(max, r-l+1);
            r++;
        }
        return (max==-1)? -1 : nums.length - max;
    }
}
