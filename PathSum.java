class Solution {                        // O(n) | O(1)
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if(root == null) return false;
        targetSum -= root.val;
        if(root.left == null && root.right == null && targetSum == 0) return true;

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);

        //return help(root, targetSum, 0); // 2
    }

    boolean help(TreeNode root, int target, int cur){ // 2

        if(root == null) 
            return false;
        cur += root.val;
        if(root.left == null && root.right == null && cur == target)
            return true;

        return help(root.left, target, cur) || help(root.right, target, cur);
    }

}
