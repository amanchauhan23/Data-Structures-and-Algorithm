class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {   // O(V + E) || O(V + E)
        for(int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<Integer>());
        for(int i = 0; i < prerequisites.length; i++)
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        List<Integer>  res =  TopoSort(numCourses);
        if(res.size() != numCourses) return new int [0];
        int rtrn [] = new int[numCourses];
        for(int i = 0; i < numCourses; i++)
            rtrn[i] = res.get(i);
        return rtrn;
    }

    public List<Integer> TopoSort(int n){
        int indegree[] = new int[n];
        List<Integer> ls = new ArrayList<>();
        for(int i = 0; i < adj.size(); i++){
            for(int j : adj.get(i))
                indegree[j]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++)
            if(indegree[i] == 0)
                q.offer(i);
        
        while(!q.isEmpty()){
            int pop = q.poll();
            for(int i = 0; i < adj.get(pop).size(); i++){
                int neighbour = adj.get(pop).get(i);
                indegree[neighbour]--;
                if(indegree[neighbour] == 0)
                    q.offer(neighbour);
            }
            ls.add(pop);
        }

        return ls;
    }

}
