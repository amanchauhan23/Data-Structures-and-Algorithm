class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) { // O(n + m)
        if(root1 == null && root2 == null)
            return new ArrayList<Integer>();
        if(root1 == null)
            return inorder(root2, new ArrayList<>());
        if(root2 == null)
            return inorder(root1, new ArrayList<>());
        
        List<Integer> l1 = inorder(root1, new ArrayList<Integer>());
        List<Integer> l2 = inorder(root2, new ArrayList<Integer>());
        List<Integer> ans = new ArrayList<>();
        
        int p1 = 0;
        int p2 = 0;
        
        while(p1 < l1.size() && p2 < l2.size()){
            if(l1.get(p1) < l2.get(p2)){
                ans.add(l1.get(p1++));
            }else{
                ans.add(l2.get(p2++));
            }
        }
        
        if(p1 == l1.size()){
            while(p2 != l2.size())
                ans.add(l2.get(p2++));
        }
        if(p2 == l2.size()){
            while(p1 != l1.size())
                ans.add(l1.get(p1++));
        }
        
        return ans;
    }
    
    public List<Integer> inorder(TreeNode root, ArrayList<Integer> ls){
        if(root == null)
            return null;
        inorder(root.left, ls);
        ls.add(root.val);
        inorder(root.right, ls);
        return ls;
    }
    
}
