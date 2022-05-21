// #1 O(N^2)
     public boolean isBalanced(TreeNode root) {
         if (root == null)
             return true;
         if (isBalanced(root.left) == false || isBalanced(root.right) == false)
             return false;
         if (Math.abs(height(root.left) - height(root.right)) > 1)
             return false;
         return true;

     }

     public int height(TreeNode root) {
         if (root == null)
             return 0;
         return Math.max(height(root.left), height(root.right)) + 1;
     }
