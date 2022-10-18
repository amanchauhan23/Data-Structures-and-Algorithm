class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) { // O(V + E) || O(V + E) 
        for(int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<Integer>());
        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int visit[] = new int[numCourses];
        boolean ans = false;
        for(int i = 0; i < numCourses; i++){  // 0 - unvisited
            if(visit[i] == 0)
                if(isCycle(i, visit))
                    return false;
        }
        return true;
    }

    boolean isCycle(int root, int visit[]){ // for detecting cyles
        if(visit[root] == 1) return true;   // 1 visited in current dfs cycle
        if(visit[root] == -1) return false;  // -1 visited in prev dfs cycle
        visit[root] = 1;
        for(int i = 0; i < adj.get(root).size(); i++){
            int neig = adj.get(root).get(i);
            if(isCycle(neig, visit)) return true;
        }
        visit[root] = -1;
        return false;
    }

}
