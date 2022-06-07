class Solution { // dfs
    List<Integer> ls = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        traversal(root);
        return ls;
    }
    public void traversal(TreeNode root){
        if(root==null)
            return;
        traversal(root.left);
        traversal(root.right);
        ls.add(root.val);
    }
}
