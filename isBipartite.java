class Solution { // O(v+e) || O(V)
    int value[];
    boolean visited[];
    public boolean isBipartite(int[][] graph) {
        visited = new boolean[graph.length];
        value = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(!visited[i])
                if(!dfs(i, graph, 0))
                    return false;
        }
        return true;
    }

    boolean dfs(int V, int [][] graph, int in){
        if(visited[V]) return true;
        visited[V] = true;
        value[V] = in;
        boolean rtrn = true;
        for(int i = 0; i < graph[V].length; i++){
            if(graph[V][i] != 0){
                int neighbour = graph[V][i];
                boolean dfsR = dfs(neighbour, graph, in + 1);
                if(value[V]%2 == value[neighbour]%2 || dfsR == false)
                    rtrn = false;
            }
        }
        return rtrn;
    } 
}
