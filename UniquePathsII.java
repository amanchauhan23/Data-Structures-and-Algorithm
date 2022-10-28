class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) { // O(mn) || O(mn)
        if(obstacleGrid[0][0] == 1) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int [][] grid = new int[m+1][n+1];

        for(int i = 0; i <= m; i++) grid[i][0] = 0;
        for(int i = 0; i <= n; i++) grid[0][1] = 0;

        grid[1][0] = 1; // for getting grid[1][1] = 1; | base condition

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(obstacleGrid[i-1][j-1] == 1) continue;
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
                
        }
        return grid[m][n];     
    
    }
}
