// similar to 0-1 matrix, use bfs from all land nodes || O(V2) | O(V)
class Solution {
    public int maxDistance(int[][] grid) {

        int l = grid.length;
        int w = grid[0].length;
        int max = -1;

        int dist[] = new int[]{0,1,0,-1,0};
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < l; i++){
            for(int j = 0; j < w; j++){
                if(grid[i][j] == 1){
                    q.offer(new int[]{i, j});
                    grid[i][j] = -1;
                }
                    
            }
        }

        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            while(size-- > 0){
                int pop[] = q.poll();
                for(int i = 0; i < 4; i++){
                    int row = pop[0] + dist[i];
                    int col = pop[1] + dist[i+1];
                    if(row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == -1 || grid[row][col] != 0)
                        continue;
                    grid[row][col] = level;
                    max = Math.max(max, level);
                    q.offer(new int[]{row, col});
                }
            }
        }
        return max;
    }
}
