    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        helper(root, l);
        return l;
    }
    public void helper(TreeNode root, List<Integer> l){
        if(root!= null){
            helper(root.left, l);
            l.add(root.val);
            helper(root.right, l);
        }
    }
