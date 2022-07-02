class Solution
{
    //Function to return list containing vertices in Topological order. 
   
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) // O(V + E) | O(V) | DFS
    {
        // add your code here
        Stack<Integer> stk = new Stack<>();
        boolean []visited = new boolean[V];
        for(int i = 0; i < V; i++)
            DFS(i, visited, stk, adj);
        int ans[] = new int[V];  
        int k = 0;
        while(!stk.isEmpty()){
            ans[k++] = stk.pop();
        }
        return ans;
    }
    
    static void DFS(int v, boolean visited[], Stack<Integer> stk, ArrayList<ArrayList<Integer>> adj){
        if(visited[v] == true)
            return;
        visited[v] =  true;
        for(int i : adj.get(v))
            DFS(i, visited, stk, adj);
        stk.push(v);
    }
    
}
