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
