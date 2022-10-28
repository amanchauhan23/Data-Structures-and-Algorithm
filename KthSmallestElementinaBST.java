// #1
class Solution {
    public int kthSmallest(TreeNode root, int k) { // O(n) | O(h)
        Stack<TreeNode> s = new Stack<>();
     
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);   
                root = root.left;
            }
            TreeNode t = s.pop();
            if(--k == 0) return t.val;
            root = t.right;
        }
        
        return -1;
    }
}

// #2 || O(n) | O(h)
class Solution {
    int count;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        ans = -1;
        help(root);
        return ans;
    }

    private void help(TreeNode root){
        if(root == null) return;
        help(root.left);
        if(--count == 0){
            ans = root.val;
            return;
        }
        help(root.right);
    }
}
