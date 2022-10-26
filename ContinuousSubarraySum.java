class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int pSum = 0;
        hm.put(pSum, -1);
        for(int i = 0; i < nums.length; i++){
            pSum += nums[i];
            if(hm.containsKey(pSum%k)){
                if(i - hm.get(pSum%k) > 1) return true;
            }else{
                hm.put(pSum%k, i);
            }
        }
        return false;
    }
}
