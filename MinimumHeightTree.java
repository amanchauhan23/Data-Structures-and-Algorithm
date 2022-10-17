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
