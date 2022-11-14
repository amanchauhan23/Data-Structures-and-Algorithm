/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Node poped = q.poll();
                if(size == 0){
                    poped.next = null;
                }else{
                    poped.next = q.peek();
                }
                if(poped.left != null)q.add(poped.left);
                if(poped.right != null)q.add(poped.right);
            }
        }

        return root;

    }
}
