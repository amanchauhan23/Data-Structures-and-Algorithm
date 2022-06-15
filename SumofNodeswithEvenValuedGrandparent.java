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
    public int sumEvenGrandparent(TreeNode root) {
        
        if(root == null)
            return -1;
        
        help(root);
        return c;
        
    }
    
    void help(TreeNode G){
        if(G == null)
            return;
        if(G.val%2 == 0){
            if(G.left != null){
                if(G.left.left != null){
                    c+=G.left.left.val;
                }
                if(G.left.right != null){
                    c+=G.left.right.val;
                }
            }
            if(G.right != null){
                if(G.right.left != null){
                    c+=G.right.left.val;
                }
                if(G.right.right != null){
                    c+=G.right.right.val;
                }
            }
        }
        help(G.left);
        help(G.right);
    }
    
}
