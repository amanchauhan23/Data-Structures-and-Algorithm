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
    public int goodNodes(TreeNode root) {
        if(root == null)
            return -1;
        int max = root.val;
        help(root, max);
        return c;
    }
    
    void help(TreeNode root, int max){
        if(root == null)
            return;
        if(root.val >= max){
            c++;
            help(root.left, root.val);
            help(root.right, root.val);
        }else{
            help(root.left, max);
            help(root.right, max);
        }
    }
    
}
