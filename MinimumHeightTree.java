// #1 Naive || O(V^2) || TLE
class Solution {
  
    List<List<Integer>> adj;
    int minHeight;
  
    public void createAdj(int n, int[][] edges){ // O(V + E)
        adj = new ArrayList<>(n);
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
    }

    public int dfsHeight(int root, int height, boolean visit[]){ // O(V + E)
        if(visit[root]) return 1;
        visit[root] = true;
        int maxHeight = height;
        if(maxHeight > minHeight) return Integer.MAX_VALUE;
        for(int i = 0; i < adj.get(root).size(); i++){
            maxHeight = Math.max(maxHeight, dfsHeight(adj.get(root).get(i), height+1, visit));
        }
        return maxHeight;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) { // O(V^2) 
        createAdj(n, edges);
        minHeight = Integer.MAX_VALUE;
        List<Integer> ls = new ArrayList<>();
        int[] heightAndNodes = new int[n];
        for(int i = 0; i < n; i++){
            int currHeight =  dfsHeight(i, 1, new boolean[n]);
            minHeight = Math.min(currHeight, minHeight);
            heightAndNodes[i] = currHeight;
        }

        for(int i = 0; i < n; i++)
            if(minHeight == heightAndNodes[i]) ls.add(i);

        return ls;
    }
}

// #2 || Max optimal root can be two. || we begin with the leaf nodes and then trim inwards, untill we are left with one or two nodes.
class Solution {

    List<List<Integer>> adj;
    
    public void createAdj(int n, int[][] edges, int [] degree){ 
        adj = new ArrayList<>(n);
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());
        for(int i = 0; i < edges.length; i++){
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ls = new ArrayList<>();
        if(n < 2){
            ls.add(0);
            return ls;
        }
        int degree[] = new int[n];
        createAdj(n, edges, degree);

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++)
            if(degree[i] == 1) q.offer(i);

        int remainingNode = n;
        while(remainingNode > 2){
            remainingNode -= q.size();
            int size = q.size();
            while(size-- > 0){
                int pop = q.poll();
                for(int i = 0; i < adj.get(pop).size(); i++){
                    int neighbour = adj.get(pop).get(i);
                    degree[neighbour]--;
                    if(degree[neighbour] == 1)
                        q.offer(neighbour);
                }
            }
        }

        while(!q.isEmpty())
            ls.add(q.poll());
        
        return ls;
    }
}
