class Solution {
    
    // iterative
//     List<Integer> ls = new ArrayList<>();
//         Stack<TreeNode> s = new Stack<>();
        
//         TreeNode cur = root;
        
//         while(cur != null || !s.isEmpty()){
//             while(cur != null){
//                 ls.add(cur.val);
//                 s.push(cur);
//                 cur = cur.left;
//             }
//             TreeNode temp = s.pop();
//             cur = temp.right;
//         }
//         return ls;
    
    // recursive
    List<Integer> ls = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        help(root);
        return ls;
    }
    public void help(TreeNode root){
        if(root==null)
            return;
        ls.add(root.val);
        help(root.left);
        help(root.right);
    }
}
