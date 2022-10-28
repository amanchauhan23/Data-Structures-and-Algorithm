class Solution {
    public int uniquePaths(int m, int n) {  // O(mn) || O(mn)

        int [][] grid = new int[m+1][n+1];

        for(int i = 0; i <= m; i++) grid[i][0] = 0;
        for(int i = 0; i <= n; i++) grid[0][1] = 0;

        grid[1][0] = 1; // for getting grid[1][1] = 1; | base condition

        for(int i = 1; i <= m; i++)
            for(int j = 1; j <= n; j++)
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            
        return grid[m][n];
    }
}

// #2 optimized || O(min(m, n))
class Solution {
    public int uniquePaths(int m, int n) {

        int totalSteps = m - 1 + n - 1;
        int least = Math.min(m, n) - 1;
        double res = 1;

        for(int i = 1; i <= least; i++, totalSteps--)
            res = (res*totalSteps)/i;
        
        return (int)res;
    }
}
