class Solution{
    public void toSumTree(Node root){
         //add code here.
         findSum(root);
    }
    
    public int findSum(Node root){
        if(root == null)
            return 0;
        int l = findSum(root.left);
        int r = findSum(root.right);
        int d = root.data;
        root.data = l + r;
        return d + l + r;
    }
    
}
