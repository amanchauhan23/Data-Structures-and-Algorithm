class Solution {
    public TreeNode invertTree(TreeNode root) { // O(n) | O(1)
        if(root == null) return null;
        invertTree(root.left);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        return root;
    }
}
