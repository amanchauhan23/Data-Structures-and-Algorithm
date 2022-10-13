class Solution
{
    private static HashMap<Integer, Integer> hm;
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        hm = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) hm.put(inorder[i], i);
        return build(inorder, preorder, 0, inorder.length -1, 0, inorder.length -1);
    }
    
    private static Node build(int in[], int pre[], int ii, int ij, int pi, int pj){
        if(pi > pj || ii > ij) return null;
        int ele = pre[pi];
        Node root = new Node(ele);
        int index = hm.get(ele);
        int diff = index - ii;
        root.left = build(in, pre, ii, index - 1, pi + 1, pi + diff);
        root.right = build(in, pre, index + 1, ij, pi + diff + 1, pj);
        return root;
    }
}
