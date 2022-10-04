class Solution {  // O(n) | O(1)
  
    List<List<Integer>> globalList;
  
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        globalList = new ArrayList<List<Integer>>();
        dfs(root, targetSum, new ArrayList<Integer>());
        return globalList;
    }

    void dfs(TreeNode root, int targetSum, List<Integer> ls){

        if(root == null) return;
        targetSum -= root.val;

        ls.add(root.val);

        if(root.left == null && root.right == null && targetSum == 0){
            globalList.add(new ArrayList<Integer>(ls));
            ls.remove(ls.size() - 1);
            return;
        }
            
        dfs(root.left, targetSum, ls);
        dfs(root.right, targetSum, ls);
        ls.remove(ls.size() - 1);

    }

}
