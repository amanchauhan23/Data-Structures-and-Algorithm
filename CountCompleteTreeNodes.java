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
    public int countNodes(TreeNode root) { // O(h*h) | O(h)
        if(root == null)
            return 0;
        int l = heightL(root.left);
        int r = heightR(root.right);
        if(l == r)
            return (2<<l) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    public int heightL(TreeNode root){
        if(root == null)
            return 0;
        return heightL(root.left) + 1;
    }
    public int heightR(TreeNode root){
        if(root == null)
            return 0;
        return heightR(root.right) + 1;
    }
}
