class Solution {
    List<Integer> ls = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        traversal(root);
        return ls;
    }
    public void traversal(Node root){
        if(root==null)
            return;
        ls.add(root.val);
        for(Node t : root.children)
            traversal(t);
    }
}
