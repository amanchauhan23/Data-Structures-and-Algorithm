class Tree
{
    int countLeaves(Node node) 
    {
         if(node == null){
             return 0;
         }
         if(node.left == null && node.right == null){
             return 1;
         }
         int l = countLeaves(node.left);
         int r = countLeaves(node.right);
         return l+r;
    }
}
