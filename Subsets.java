// #1
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        help(nums, 0, new ArrayList<Integer>());
        return res;
    }

    void help(int[] nums, int i, List<Integer> ls){ // backtracking
        if(i == nums.length){
            res.add(new ArrayList<>(ls));
            return;
        }
        help(nums, i + 1, ls); // didn't pick condition
        ls.add(nums[i]);
        help(nums, i + 1, ls); // picked
        ls.remove(ls.size()-1);
    }
}

//  #2
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
}
