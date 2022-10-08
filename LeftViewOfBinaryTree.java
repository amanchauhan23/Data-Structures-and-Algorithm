// O(n) || O(h)
class Tree 
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
        
            int size = q.size();
            int r = -1;
            
            while(size-- > 0){
                Node pop = q.poll();
                if(r++ == -1) ls.add(pop.data);
                
                if(pop.left != null)
                    q.offer(pop.left);
                    
                if(pop.right != null)
                    q.offer(pop.right);
    
            }
        }
        return ls;
    }
}
