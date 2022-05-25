public int minDepth(TreeNode root) {
        // #1
        // if(root==null)
        //     return 0;
        // int l = minDepth(root.left);
        // int r = minDepth(root.right);
        // if(l==0)
        //     l = Integer.MAX_VALUE;
        // else if(r==0)
        //     r = Integer.MAX_VALUE;
        // return Math.min(l,r)+1;
        
        // #2
        if (root == null) 
            return 0;
        
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right))+1; 
    }
