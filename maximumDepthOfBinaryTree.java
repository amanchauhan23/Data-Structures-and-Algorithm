public int maxDepth(TreeNode root) { // O(n)
        if(root==null)
            return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
