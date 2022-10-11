// #1 | use LIS if(LIS>=3) return true || O(n^2) or O(nlogn)

// #2 || Optimized
class Solution {
    public boolean increasingTriplet(int[] nums) { // Greedy || O(n) | O(1)
        int n = nums.length;
        if(n < 3) return false;
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(nums[i] <= min){
                min = nums[i];
            }else if(nums[i] <= mid){
                mid = nums[i];
            }else{
                return true;
            }
        }
        return false;
    }
}
