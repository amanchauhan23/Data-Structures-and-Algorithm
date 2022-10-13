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

class Solution {
    HashMap<Integer, Integer> hm;
    public TreeNode buildTree(int[] inorder, int[] postorder) { 
        hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) hm.put(inorder[i], i);
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode build(int [] inorder, int[] postorder, int ii, int ij, int pi, int pj){
        if(pi > pj || ii > ij) return null;
        int lastElem = postorder[pj];
        int inorderIndex = hm.get(lastElem);
        int diff = inorderIndex - ii - 1;
        TreeNode root = new TreeNode(lastElem);
        root.left = build(inorder, postorder, ii, inorderIndex - 1, pi, pi + diff);
        root.right = build(inorder, postorder, inorderIndex + 1, ij, pi + diff + 1, pj - 1);
        return root;
    }
}
