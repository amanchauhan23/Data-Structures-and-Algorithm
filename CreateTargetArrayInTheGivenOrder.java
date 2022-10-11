class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> ls = new ArrayList<>();
        for(int i = 0; i < index.length; i++)
            ls.add(index[i], nums[i]);
        
        int ans[] = new int[ls.size()];
        int j = 0;
        for(int i : ls) ans[j++] = i;
        return ans;
    }
}
