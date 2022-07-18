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
// class Solution { 
//     static int count = 0;
//     int ans = -1;
//     public int kthSmallest(TreeNode root, int k) { // recursive | O(n) | O(h) 
//         count = k;
//         help(root, k);
//         return ans;
//     }
    
//     void help(TreeNode root, int k){
//         if(root == null)
//             return;
//         help(root.left, k);
//         if(--count == 0){
//             ans = root.val;
//             return;
//         }
//         help(root.right, k);
//     }
    
// }
