/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// #1
class Solution {
    HashMap<Integer , Integer> map ;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length ;
         map = new HashMap<>() ;
        for (int i = 0; i < n; i++) {
            map.put(preorder[i], i ) ;
        }
        
        return helper(preorder , postorder , 0 , n-1 , 0 , n-1) ;
    }

    private TreeNode helper(int[] preorder, int[] postorder, int s_pre, int e_pre, int s_po, int e_po) {
        if(s_pre>e_pre) return null ;
        if(s_pre == e_pre) return new TreeNode(preorder[s_pre]) ;
        
        int val = postorder[e_po] ;
        TreeNode root = new TreeNode(val) ;
        int i = map.get(postorder[e_po-1]) ;
        
        int x = s_po + i- s_pre -2 ;
        root.left = helper(preorder , postorder , s_pre+1, i-1 , s_po , x) ;
        
        root.right = helper(preorder, postorder , i ,e_pre , x+1 ,e_po -1) ;
        return root ;
        
        
    }
}

// #2
class Solution {
    int preIndex = 0, postIndex = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if(root.val != postorder[postIndex])
            root.left = constructFromPrePost(preorder, postorder);
        if(root.val != postorder[postIndex])
            root.right = constructFromPrePost(preorder, postorder);
        postIndex++;
        return root;
    }
}
