class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj) // O(V + E) | O(V)
    {
        int visit[] = new int[V];
        
        for(int i = 0; i < V; i++){
            if(visit[i] == 0)
                if(dfs(i, visit, i, adj) == false)
                    return false;
        }
        return true;
    }

    boolean dfs(int V, int visit[],int parent, ArrayList<ArrayList<Integer>>adj){
        if(visit[V] !=  0){
            if(visit[parent] == 1 && visit[V] == -1)
                return true;
            if(visit[parent] == -1 && visit[V] == 1)
                return true;
            return false;
        }
        if(visit[parent] == -1)
            visit[V] = 1;
        else
            visit[V] = -1;
            
        for(int i : adj.get(V))
            if(i != parent){
                if(dfs(i, visit, V, adj) == false)
                    return false;
            }

        return true;
    }
}
