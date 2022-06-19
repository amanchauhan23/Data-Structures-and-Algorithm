//User function Template for Java
/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

// Function should return the root of the bst formed using postorder traversal.
class GFG
{
    private static int k = 0;
    public static Node constructTree(int post[],int n){ // O(n) | O(h)
        k  = n - 1;
        return construct(post, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public static Node construct(int post[], int Lbound, int Rbound){
        if(k == -1 || post[k] < Lbound || post[k] > Rbound)
            return null;
        Node t = new Node(post[k--]);
        t.right = construct(post, t.data, Rbound);
        t.left = construct(post, Lbound, t.data);
        
        return t;
    }
    
}
