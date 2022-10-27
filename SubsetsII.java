class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        help(nums, 0, new ArrayList<Integer>());
        return res;
    }

    void help(int[] nums, int i, List<Integer> ls){ // backtracking
        if(i >= nums.length){
            res.add(new ArrayList<>(ls));
            return;
        }

        ls.add(nums[i]);
        help(nums, i + 1, ls); // picked
        ls.remove(ls.size()-1);

        int j = i;
        while(j + 1 < nums.length && nums[j] == nums[j+1]) j++; // skipping same elements
        help(nums, j + 1, ls); // didn't pick condition

    }
}
