// O(n) || O(h)
class Solution {
    List<String> ls = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return ls;
        dfs(root, "");
        return ls;
    }

    private void dfs(TreeNode root, String s){
        if(root == null) return;

        s += String.valueOf(root.val);
        if(root.left == null && root.right == null)
            ls.add(s);

        s += "->";

        dfs(root.left, s);
        dfs(root.right, s);
    }

}
