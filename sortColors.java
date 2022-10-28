class Solution {
    public void sortColors(int[] nums) {   // O(n) || O(1)
        int left = 0, right = nums.length - 1;
        int i = 0;
        while(left <= right){
            if(nums[left] == 0){
                nums[left] = nums[i];
                nums[i] = 0;
                left++;
                i++;
            }else if(nums[left] == 1){
                left++;
            }else{
                nums[left] = nums[right];
                nums[right] = 2;
                right--;
            }
        }
    }
}
