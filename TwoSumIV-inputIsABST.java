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
    HashSet<Integer> hs = new HashSet<>();
    boolean ans = false;
    public boolean findTarget(TreeNode root, int k) { // O(n) || O(n) || works with BT in general
        if(root == null) return true;
        if(hs.contains(k - root.val)) ans = true;
        hs.add(root.val);
        findTarget(root.left, k);
        findTarget(root.right, k);
        return ans;
    }
}

// #2 || aux Space O(h)
class Solution {
    TreeNode root;
    public boolean findTarget(TreeNode root, int k) {
        this.root = root;
        return dfs(root, k);
    }

    private boolean dfs(TreeNode curr, int k){
        if(curr == null) return false;
        if(curr.val != k / 2){
            if(find(root, k - curr.val)) return true;
        }
        return dfs(curr.left, k) || dfs(curr.right, k);
    }

    private boolean find(TreeNode root, int rem){
        if(root == null) return false;
        if(root.val == rem) return true;
        else if(root.val > rem) return find(root.left, rem);
        else return find(root.right, rem);
    }

}
