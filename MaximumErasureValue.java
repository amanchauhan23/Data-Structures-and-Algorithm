class Solution {
    public int maximumUniqueSubarray(int[] nums) {  // O(n) | O(m) m - unique elem.
        HashSet<Integer> hs = new HashSet<>();
        int l =0; int r =0;
        int max = 0;
        int sum = 0;
        while(r<nums.length){
            
                if(hs.contains(nums[r])){
                    hs.remove(nums[l]);
                    sum -= nums[l++];
                }else{
                    sum += nums[r];
                    hs.add(nums[r++]);
                }
             max = Math.max(max, sum);
            
            }

        return max;
    }
}
