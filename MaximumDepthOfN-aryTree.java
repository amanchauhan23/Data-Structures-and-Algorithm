/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution { // O(n) || O(1)
    int max = 0;
    public int maxDepth(Node root) {
        if(root == null) return 0;
        if(root.children.size() == 0) return 1;
        int maxb = 0;
        for(int i = 0; i < root.children.size(); i++){
            maxb = Math.max(maxDepth(root.children.get(i)), maxb);
        }
        max = Math.max(maxb, max);
        return maxb + 1;
    }
}
