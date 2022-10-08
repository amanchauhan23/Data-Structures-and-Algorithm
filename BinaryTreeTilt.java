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
    int sum = 0;
    public int findTilt(TreeNode root) {    // O(n) || O(h)
        find(root);
        return sum;
    }

    int find(TreeNode root){
        if(root == null) return 0;
        int ogValue = root.val;
        int left = find(root.left);
        int right = find(root.right);
        root.val = Math.abs(left - right);
        sum += root.val;
        ogValue += left;
        ogValue += right;
        return ogValue;
    }
}
