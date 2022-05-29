class Solution {
    List<Integer> ls = new ArrayList<Integer>();
    public List<Integer> postorder(Node root) {
        traversal(root);
        return ls;
    }
    public void traversal(Node root){
        if(root==null)
            return;
        for(Node t : root.children)
            traversal(t);
        
        ls.add(root.val);
    }
}
