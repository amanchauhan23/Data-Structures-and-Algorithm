// #1 
// O(n^2) || O(n^2) || creating adj list for undirected Graph, after getting the max(element) in tree
class Solution {

    List<List<Integer>> adj;
    public int amountOfTime(TreeNode root, int start) {
        adj = new ArrayList<>();
        maxVAL(root);
        // System.out.println(max);
        for(int i = 0; i < max; i++)
            adj.add(new ArrayList<Integer>());
        adjMaker(root);

        // For viewing adjList
        // for(int i = 0; i < adj.size(); i++){
        //     for(int j : adj.get(i))
        //         System.out.print(i + " -> " + j + " | ");
        //     System.out.println();
        // }

        Queue<Integer> q = new LinkedList<>();
        boolean visit[] = new boolean[max];
        int src = start - 1;
        q.offer(src);
        int level = -1;
        
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            while(size-- > 0){
                int pop = q.poll();
                visit[pop] = true;
                for(int i = 0; i < adj.get(pop).size(); i++){
                    int neighbour = adj.get(pop).get(i);
                    if(!visit[neighbour]){
                        q.offer(neighbour);
                    }
                }
            }
        }
    return level;
    }

    public void adjMaker(TreeNode root){
        if(root == null) return;
        int rootVal = root.val;
        if(root.left != null){
            adj.get(rootVal - 1).add(root.left.val - 1); // undirected graph | a <-> b
            adj.get(root.left.val - 1).add(rootVal - 1);
        }
        if(root.right != null){
            adj.get(rootVal - 1).add(root.right.val - 1);
            adj.get(root.right.val - 1).add(rootVal - 1);
        }
        adjMaker(root.left);
        adjMaker(root.right);
    }

    int max = Integer.MIN_VALUE;

    private void maxVAL(TreeNode root){
        if(root == null) return;
        max = Math.max(max, root.val);
        maxVAL(root.left);
        maxVAL(root.right);
    }
}

// #2
// Storing the parent,and finding max from left, right, and parent
class Solution {

    HashMap<TreeNode, TreeNode> hm;
    TreeNode src = null;
    HashSet<TreeNode> visit;
    public int amountOfTime(TreeNode root, int start) {
        if(root == null) return 0;
        hm = new HashMap<>();
        visit = new HashSet<>();
        hm.put(root, null);
        dfsParent(root, start);
        System.out.println(src.val);
        return dfsDist(src) - 1;
    }

    private int dfsDist(TreeNode root){
        if(root == null || visit.contains(root)) return 0;
        visit.add(root);
        return Math.max(dfsDist(root.left), Math.max(dfsDist(root.right), dfsDist(hm.get(root)))) + 1;
    }

    private void dfsParent(TreeNode root, int start){
        if(root == null) return;
        if(start == root.val) src = root;
        if(root.left != null) hm.put(root.left, root);
        if(root.right != null) hm.put(root.right, root);
        dfsParent(root.left, start);
        dfsParent(root.right, start);
    }

}
