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
class Solution { // O(n) || O(n)
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
        
            int size = q.size();
            int r = -1;

            while(size-- > 0){
                TreeNode pop = q.poll();
                r = pop.val;
                if(pop.left != null)
                    q.offer(pop.left);
                    
                if(pop.right != null)
                    q.offer(pop.right);
    
            }
            ls.add(r);
        }
        return ls;
    }
}
