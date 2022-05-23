public static boolean isSameTree(TreeNode p, TreeNode q) {
        return inorderCheck(p, q);
        // or use preOrderCheck or postOrder
    }

    public static boolean inorderCheck(TreeNode p, TreeNode q) { // O(n)
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        return (inorderCheck(p.left, q.left) && (p.val == q.val) && inorderCheck(p.right, q.right));
    }

    // public static boolean preOrderCheck(TreeNode p, TreeNode q) {
    // if (p == null && q == null)
    // return true;
    // else if (p == null || q == null)
    // return false;
    // return (p.val == q.val) && preOrderCheck(p.left, q.left) &&
    // preOrderCheck(p.right, q.right);
    // }
