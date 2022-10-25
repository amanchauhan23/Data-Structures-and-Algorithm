class Solution {
    public int majorityElement(int[] nums) {
        int majEle = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == majEle)
                count++;
            else{
                if(count == 0){
                    majEle = nums[i];
                    count++;
                }else{
                    count--;
                }
            }
        }
        return majEle;
    }
}
