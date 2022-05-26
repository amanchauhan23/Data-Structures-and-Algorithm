 public boolean hasPathSum(TreeNode root, int sum) { // O(N)      
        if(root==null)
            return false;
        if(root.left==null && root.right==null && sum-root.val==0)
            return true;
        int diff=sum-root.val;
        return hasPathSum(root.left,diff) || hasPathSum(root.right,diff);  
    }
