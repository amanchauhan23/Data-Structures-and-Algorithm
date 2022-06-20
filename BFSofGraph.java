class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) { // O(V + E) | O(V)
        
        int src = 0;
        int visited[] = new int[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ls = new ArrayList<>();
        q.offer(src);
        visited[0] = 1;
        
        while(!q.isEmpty()){
            int pop = q.remove();
            ls.add(pop);
            for(int i = 0; i < adj.get(pop).size(); i++){
                if(visited[adj.get(pop).get(i)] == 1)
                    continue;
                visited[adj.get(pop).get(i)] = 1;
                q.offer(adj.get(pop).get(i));
            }
        }
        
        return ls;
    }
}
