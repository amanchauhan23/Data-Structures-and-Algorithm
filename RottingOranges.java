class Solution { // O(V^2) || O(V^2) 
    public int orangesRotting(int[][] grid) {

        int dir[] = new int[]{0,1,0,-1,0};
        int l = grid.length;
        int w = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for(int i = 0; i < l; i++){
            for(int j = 0; j < w; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                    grid[i][j] = -1;
                }
                if(grid[i][j] == 1) fresh++;
            }
        }

        if(fresh == 0) return 0;

        int minSec = -1;
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            while(size-- > 0){
                int pop[] = q.poll();
                for(int i = 0; i < 4; i++){
                    int row = pop[0] + dir[i];
                    int col = pop[1] + dir[i+1];
                    
                    if(row < 0 || col < 0 || row == l || col == w || grid[row][col] == 0 || grid[row][col] == -1) continue;
                    q.offer(new int[]{row, col});
                    grid[row][col] = -1;
                    minSec = level;
                    fresh--;
                }
            }
        }

        if(fresh != 0) return -1; 
        return minSec;
    }
}
