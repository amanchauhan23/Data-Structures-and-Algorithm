class Solution {
    List<Integer> ls = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        help(root);
        return ls;
    }
    public void help(TreeNode root){
        if(root==null)
            return;
        ls.add(root.val);
        help(root.left);
        help(root.right);
    }
}
