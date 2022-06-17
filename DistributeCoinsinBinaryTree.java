class Solution {
    int ans = 0;
    public int distributeCoins(TreeNode root) { // O(n) | O(h)
        helper(root);
        return ans;
    }
    
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = helper(root.left);
        int r = helper(root.right);
        
        ans += Math.abs(l) + Math.abs(r);
        
        return l + r + root.val - 1; // keeping one for curr node, -1
    }
    
}
