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
    public TreeNode reverseOddLevels(TreeNode root) {

        if(root == null) return null;

        TreeNode rtrn = root;
        Queue<TreeNode> q = new LinkedList<>();
        Stack<Integer> stck = new Stack<>();

        q.offer(root);
        int level = 0;

        while(!q.isEmpty()){
            
            int size = q.size();

            for(int i = 0; i < size; i++){
                TreeNode pop = q.poll();
                if(level%2 == 1) pop.val = stck.pop();
                if(pop.left != null){
                    q.offer(pop.left);
                    if(level%2 == 0) stck.push(pop.left.val);
                }
                if(pop.right != null){
                    q.offer(pop.right);
                    if(level%2 == 0) stck.push(pop.right.val);
                }
            }
            level++;
        }
        return rtrn;
    }
}
