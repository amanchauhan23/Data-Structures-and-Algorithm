class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        if(node == null){
            return;
        }
        
        mirror(node.left);
        mirror(node.right);
        
        Node tempL = node.left;
        node.left = node.right;
        node.right = tempL;
        
        // mirror(node.left); // will work as well
        // mirror(node.right);
        return;
    }
}
