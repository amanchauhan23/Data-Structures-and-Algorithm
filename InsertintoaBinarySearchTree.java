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

// #1
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) { // iterative | O(h) | O(1)
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode head = root;
        while(true){
            if(root.val > val){
                if(root.left != null){
                    root = root.left;
                }else{
                    root.left = new TreeNode(val);
                    break;
                }
                
            }else{
                if(root.right != null){
                    root = root.right;
                }else{
                    root.right = new TreeNode(val);
                    break;
                }
            }
        }
        return head;
    }
}

// #2
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) { // recursive | O(h) | O(h)
        if(root == null){
            return new TreeNode(val);
        }
        if(root.val > val){
            root.left = insertIntoBST(root.left, val);
        }else{
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
