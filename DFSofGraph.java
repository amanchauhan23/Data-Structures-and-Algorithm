class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    int v[];
    ArrayList<Integer> ls;
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) { // O(v + e) | O(v)
        // Code 
        ls = new ArrayList<>();
        v = new int[adj.size()];
        
        for(int i = 0; i < adj.size(); i++)
            dfs(i, adj);
        
        return ls;
        
    }
    
    void dfs(int val, ArrayList<ArrayList<Integer>> adj){
        if(v[val] != 0)
            return;
        ls.add(val);
        v[val] = -1;
        for(int i = 0; i < adj.get(val).size(); i++){
            dfs(adj.get(val).get(i), adj);
        }
            
    }
    
}
