class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {  // O(n) || O(1)
        if(depth == 1){
            return new TreeNode(val, root, null);
        }
        dfsAdd(root, val, depth - 1);
        return root;
    }

    void dfsAdd(TreeNode root, int val, int depth){
        if(root == null) return;
        if(depth == 1){
            TreeNode leftNext = root.left;
            TreeNode rightNext = root.right;
            root.left = new TreeNode(val, leftNext, null);
            root.right = new TreeNode(val, null, rightNext);
            return;
        }

        dfsAdd(root.left, val, depth - 1);
        dfsAdd(root.right, val, depth - 1);
    }
}
