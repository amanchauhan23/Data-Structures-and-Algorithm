class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        help(0, candidates, target, new ArrayList<Integer>());
        return res;
    }

    private void help(int i, int candidates[], int target, List<Integer> ls){

        if(target < 0 || i >= candidates.length) return;
        if(target == 0){
            res.add(new ArrayList<>(ls));
            return;
        }

        help(i+1, candidates, target, ls);
        ls.add(candidates[i]);
        help(i, candidates, target - candidates[i], ls);
        ls.remove(ls.size() - 1);
    }
}
