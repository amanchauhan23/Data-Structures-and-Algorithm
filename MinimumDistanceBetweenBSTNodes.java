class Solution {
    int min = Integer.MAX_VALUE;
    int pre = 1000000;
    public int minDiffInBST(TreeNode root) { // O(n) | O(h)
        minn(root);
        return min;
    }
    
    public void minn(TreeNode root){
        if(root == null)
            return;
        minn(root.left);
        min = Math.min(min, Math.abs(root.val - pre));
        pre = root.val;
        minn(root.right);
    }
}
