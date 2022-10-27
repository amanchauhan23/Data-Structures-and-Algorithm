class Solution {
    public int[] productExceptSelf(int[] nums) { // O(n) || O(1)
        int noOfZeros = 0;
        int product = 1;
        int res[] = new int[nums.length];
        for(int i : nums){
            if(i == 0) noOfZeros++;
            else product *= i;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0 && noOfZeros == 0){
                res[i] = product/nums[i];
            }else if(nums[i] != 0 && noOfZeros != 0){
                res[i] = 0;
            }else{
                if(noOfZeros > 1) res[i] = 0;
                else res[i] = product;
            }
        }
        return res;
    }
}
