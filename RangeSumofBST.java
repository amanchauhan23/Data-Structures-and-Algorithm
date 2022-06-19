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
    
    private int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) { 
        
        // #1
        // if(root == null)
        //     return 0;
        // if(root.val >= low && root.val <= high){
        //     sum += root.val;
        // }
        // rangeSumBST(root.left, low, high);
        // rangeSumBST(root.right, low, high);
        // return sum;
        
        // #2
        if(root == null)
            return 0;
        if(root.val >= low && root.val <= high)
            sum += root.val;
        if(root.val > low ) 
            rangeSumBST(root.left, low, high);
        if(root.val < high) 
            rangeSumBST(root.right, low, high);
        
        return sum;
    }
}
