/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    private long prev = Long.MIN_VALUE;
    
    public boolean isValidBST(TreeNode root) { // O(n) | O(h) // inorder of bst is sorted
        if(root == null)
            return true;
        boolean l = isValidBST(root.left);
        if(root.val <= prev)
            return false;
        prev = root.val;
        boolean r = isValidBST(root.right);
        return l && r;
    }
}
