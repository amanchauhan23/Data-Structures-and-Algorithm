class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            if(i>0&& nums[i] == nums[i-1])
                continue;
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                if(nums[i]+nums[left]+nums[right]>0){
                    right--;
                }else if(nums[i]+nums[left]+nums[right]<0){
                    left++;
                }else{
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[left]);
                    ans.add(nums[right]);
                    ls.add(ans);
                    right--;
                    while(left<right && nums[right] == nums[right+1])
                        right--;
                }
            }
        }
        return ls;
    }
}
