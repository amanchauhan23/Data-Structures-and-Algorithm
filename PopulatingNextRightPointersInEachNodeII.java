class Solution {
    public Node connect(Node root) { // O(n) || O(n/2)
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
