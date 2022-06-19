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
    int k = 0;
    public TreeNode bstFromPreorder(int[] preorder) { // O(n) | O(h)
        return bstCreate(preorder, Integer.MAX_VALUE);
    }
    
    public TreeNode bstCreate(int[] preorder, int bound){
        if(k == preorder.length || preorder[k] > bound){
            return null;
        }
        TreeNode t = new TreeNode(preorder[k++]);
        t.left = bstCreate(preorder, t.val);
        t.right = bstCreate(preorder, bound);
        return t;
    }
    
}
