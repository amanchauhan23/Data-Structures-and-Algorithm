class Solution {
    public int findClosestNumber(int[] nums) {

        int diff = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        
        for(int i : nums){
            if(Math.abs(i) < diff){
                diff = Math.abs(i);
                ans = i;
            }else if(Math.abs(i) == diff){
                if(i > ans) ans = i;
            }
        }
        
        return ans;
    }
}
