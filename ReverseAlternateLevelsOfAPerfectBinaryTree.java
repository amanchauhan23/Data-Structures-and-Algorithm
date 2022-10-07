/*
// A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}


*/
// O(n) || O(n)
class Tree
{
	static void reverseAlternate( Node root)  
    {  
        if(root == null) return;

        Node rtrn = root;
        Queue<Node> q = new LinkedList<>();
        Stack<Integer> stck = new Stack<>();

        q.offer(root);
        int level = 0;

        while(!q.isEmpty()){
            
            int size = q.size();

            for(int i = 0; i < size; i++){
                Node pop = q.poll();
                if(level%2 == 1) pop.data = stck.pop();
                if(pop.left != null){
                    q.offer(pop.left);
                    if(level%2 == 0) stck.push(pop.left.data);
                }
                if(pop.right != null){
                    q.offer(pop.right);
                    if(level%2 == 0) stck.push(pop.right.data);
                }
            }
            level++;
        }
        return;
    }  
}
