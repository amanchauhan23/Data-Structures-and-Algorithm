    public List<Integer> inorderTraversal(TreeNode root) {
        
        // iterative 
//         List<Integer> ls = new ArrayList<>();
//         Stack<TreeNode> s = new Stack<>();
        
//         TreeNode cur = root;
        
//         while(cur != null || !s.isEmpty()){
//             while(cur != null){
//                 s.push(cur);
//                 cur = cur.left;
//             }
//             TreeNode temp = s.pop();
//             ls.add(temp.val);
//             cur = temp.right;
//         }
//         return ls;
        
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
