class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {  // O(v + e) || O(v + e)

        // Creating adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<Integer>());
        for(int i = 0; i < dislikes.length; i++){
            adj.get(dislikes[i][0] - 1).add(dislikes[i][1] - 1);
            adj.get(dislikes[i][1] - 1).add(dislikes[i][0] - 1);
        }

        int color[] = new int[n]; // 0 -> not visited, 1 -> black, -1 -> white

        for(int i = 0; i < n; i++){
            if(color[i] == 0 && !bipartite(adj, color, i, 1))
                return false;
        }
        return true;
    }

    // is graph bipartite || as we only want to divide graph in two sets
    public boolean bipartite(ArrayList<ArrayList<Integer>> adj, int color[], int node, int c){
        if(color[node] != 0)
            return color[node] == c;
        color[node] = c;
        for(int n : adj.get(node)){
            if(!bipartite(adj, color, n, -c))
                return false;
        }
        return true;
    }
}
