class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) { // O(V + E) || O(V)
        boolean visit[] = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(visit[i] == false && dfs(i, -1, visit, adj))
                return true;
        }
        return false;
    }
    
    boolean dfs(int node, int parent, boolean visit[], ArrayList<ArrayList<Integer>> adj){
        if(visit[node] == true)
            return true;
        visit[node] = true;
        for(int i = 0; i < adj.get(node).size(); i++){
            int v = adj.get(node).get(i);
            if(v != parent)
                if(dfs(v, node, visit, adj))
                    return true;
        }
        return false;
    }
    
}
