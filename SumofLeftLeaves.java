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
    public int sumOfLeftLeaves(TreeNode root) {
       return help(root, false);
    }
    
    public int help(TreeNode root, boolean flag){
        if(root == null)
            return 0;
        else if(root.left == null && root.right == null && flag){
            return root.val;
        }
        
        int l = help(root.left, true);
        l += help(root.right, false);
        return l;
        
    }
}
