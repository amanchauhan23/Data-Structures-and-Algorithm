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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {  // O(n) || O(h) 
        List<List<Integer>> ls = new ArrayList<>();
        if(root == null) return ls;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean switchOrder = false;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> localLS = new ArrayList<>();
            while(size-- > 0){
                TreeNode pop = q.poll();
                localLS.add(pop.val);
                if(pop.left != null) q.offer(pop.left);
                if(pop.right != null) q.offer(pop.right);
            }
            if(switchOrder) Collections.reverse(localLS);
            ls.add(localLS);
            switchOrder = !switchOrder;
        }
        return ls;
    }
}
