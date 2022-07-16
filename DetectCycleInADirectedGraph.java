class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) { // O(V + E) | O(V)
        int visit[] = new int[V]; // -1 visited, but not in current dfs call
                                  // 1 visited in current dfs call, 0 not visited
        for(int i = 0; i < V; i++){
            if(visit[i] == 0){
                if(dfs(i, visit, adj))
                    return true;
            }    
        }
        return false;
    }
    
    boolean dfs(int node, int visit[], ArrayList<ArrayList<Integer>> adj){
        if(visit[node] == 1)
            return true;
        else if(visit[node] == -1)
            return false;
        
        visit[node] = 1;
      
        for(int i : adj.get(node)){
            if(dfs(i, visit, adj))
                return true;
        }
      
        visit[node] = -1;
        return false;
    }
}
