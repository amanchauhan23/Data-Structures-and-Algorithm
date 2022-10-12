// #1 
class Solution {
    public String tree2str(TreeNode root) {
        if(root == null) return "";
        String ans = "";
        ans += root.val + "";
        String left = tree2str(root.left);
        String right = tree2str(root.right);
        if(left == "" && right == "") return ans;
        if(left != "" && right == "") ans += "(" + left + ")";
        if(left == "" && right != "") ans += "()" + "(" + right + ")";
        if(left != "" && right != "") ans += "(" + left + ")" + "(" + right + ")";
        return ans; 
    }
}

// #2
class Solution {
    public String tree2str(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if(root.left != null){
            sb.append("(");
            sb.append(tree2str(root.left));
            sb.append(")");
        }
        if(root.right != null){
            if(root.left == null){
                sb.append("()");
            }
            sb.append("(");
            sb.append(tree2str(root.right));
            sb.append(")");
        }
        return sb.toString();
    }
}
