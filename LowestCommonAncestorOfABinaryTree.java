// #1
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val) return root;
      
        boolean pInLeft = find(root.left, p.val);
        boolean pInRight = find(root.right, p.val);
        boolean qInLeft = find(root.left, q.val);
        boolean qInRight = find(root.right, q.val);
      
        if((pInLeft && qInRight) || (pInRight && qInLeft)) return root;
        else if(pInLeft && qInLeft) return lowestCommonAncestor(root.left, p, q);
        else return lowestCommonAncestor(root.right, p, q);
    }

    public boolean find(TreeNode root, int x){
      
        if(root == null) return false;
        if(root.val == x) return true;
        return find(root.left, x) || find(root.right, x);
      
    }
}

// #2
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        else if(right == null) return left;
        else return root;
      
    }
}
