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
    int freq = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        sum(root, hm);
        for(Map.Entry<Integer, Integer> me : hm.entrySet()){
            if(me.getValue() == freq){
                list.add(me.getKey());
            }
        }
        int ans[] = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    
    public int sum(TreeNode root, HashMap<Integer, Integer> hm){
        
        if(root == null){
            return 0;
        }
        
        
        int lSum = sum(root.left, hm);
        int rSum = sum(root.right, hm);
        
        int total = root.val + lSum + rSum;
        
        hm.put(total, hm.getOrDefault(total, 0)+1);
        
        freq = Math.max(freq, hm.get(total));
        
        return total;
    }
    
}
