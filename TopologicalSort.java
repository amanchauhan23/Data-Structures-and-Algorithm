// Kahn's Algorithm || BFS based
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int degree[];
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) // O(V + E) | O(V)
    {
        degree = new int[V]; // in-degree 
        for(int i = 0; i < adj.size(); i++){
            for(int j : adj.get(i))
                degree[j]++;
        }
        int [] ans = new int[V];
        Arrays.fill(ans, -1);
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < degree.length; i++){
            if(degree[i]==0)
                q.offer(i);
        }
        int k = 0;
        while(!q.isEmpty()){
            int pop = q.poll();
            ans[k] = pop;
            k++;
            for(int i = 0; i < adj.get(pop).size(); i++){
                degree[adj.get(pop).get(i)]--;
                if(degree[adj.get(pop).get(i)] == 0) // only whose in-degree is zero, is added
                    q.offer(adj.get(pop).get(i));
            }
        }
        
        return ans;
    }
}
