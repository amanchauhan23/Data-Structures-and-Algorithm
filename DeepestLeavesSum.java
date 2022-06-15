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
    int c = 0;
    public int deepestLeavesSum(TreeNode root) {
        
        if(root == null)
            return -1;
        
        int max = maxHeight(root);
        findSum(root, max-1);
        return c;
    }
    
    public void findSum(TreeNode root, int max){
        if(root == null)
            return;
        if(max == 0)
            c+=root.val;
        findSum(root.left, max-1);
        findSum(root.right, max-1);
        
    }
    
    public int maxHeight(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(maxHeight(root.left), maxHeight(root.right)) + 1;
    }
}
