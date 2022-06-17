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
    
    public TreeNode getMax(TreeNode root){ // for getting max in left subtree
        if(root == null)
            return null;
        if(root.right != null)
            return getMax(root.right);
        return root;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) { // O(h) | O(h)
        if(root == null)
            return null;
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null && root.right == null){ // node has 0 child
                return null;
            }else if(root.left == null && root.right != null){ // for 1 child
                return root.right;
            }else if(root.left != null && root.right == null){ // for 1 child
                return root.left;
            }else{                                          // for 2 child
                TreeNode max = getMax(root.left);
                root.val = max.val;
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
}
