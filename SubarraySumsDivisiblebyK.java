class Solution {
    public int subarraysDivByK(int[] nums, int k) { // O(n) | O(n)
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int count = 0;
        hm.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            sum+=nums[i];
            int r = sum%k;
            if(r<0)
                r+=k;
            if(hm.containsKey(r)){
                count+=hm.get(r);
            }
            hm.put(r, hm.getOrDefault(r, 0)+1);
        }
        return count;
    }
}
