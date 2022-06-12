class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) { // O(n^2) | O(n^2)
        int count = 0;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int c : nums3)
            for(int d : nums4)
                hm.put(c + d, hm.getOrDefault(c + d, 0) + 1);
        
        for(int a : nums1)
            for(int b : nums2)
                if(hm.containsKey(-(a + b)))
                    count+=hm.get(-(a + b));
    
        return count;
    }
}
