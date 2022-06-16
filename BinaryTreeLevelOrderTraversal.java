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
    public List<List<Integer>> levelOrder(TreeNode root) {
       
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ls = new ArrayList<>();
        
        if(root == null)
            return ls;
        
        List<Integer> l = new ArrayList<>();
        
        q.add(root);
        q.add(null);
        
        while(q.size()>1){
            TreeNode t = q.poll();
            if(t == null){
                ls.add(l);
                l = new ArrayList<>();
                q.add(null);
                continue;
            }
            l.add(t.val);
            if(t.left != null){
                q.add(t.left);
            }if(t.right != null){
                q.add(t.right);
            }
        }
        ls.add(l);
        return ls;
    }
}
