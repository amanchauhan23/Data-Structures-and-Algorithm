class Solution {
    public int numIslands(char[][] grid) { // O(n) || O(n) || using bfs
        int ans = 0; 
        int L = grid.length;
        int W = grid[0].length;

        boolean visited[][] = new boolean[L][W];
        int [][] dir = {
            {0,1}, {1, 0},
            {0, -1}, {-1, 0}
        };

        for(int i = 0; i < L; i++){
            for(int j = 0; j < W; j++){
                if(visited[i][j] == false && grid[i][j] == '1'){
                    ans++;
                    Queue<Integer []> q = new LinkedList<>();
                    q.offer(new Integer[]{i, j});
                    while(!q.isEmpty()){
                        Integer poll[] = q.remove();
                        System.out.println(poll[0] + " " + poll[1]);
                        visited[poll[0]][poll[1]] = true;
                        for(int k = 0; k < dir.length; k++){
                            int row = poll[0] + dir[k][0];
                            int col = poll[1] + dir[k][1];
                            if(row >= 0 && row < L && col >= 0 && col < W){
                                if(grid[row][col] == '1' && !visited[row][col]){
                                    visited[row][col] = true;
                                    q.offer(new Integer[]{row, col});
                                }
                            }
                        }
                    }
                    System.out.println("getting out");
                }
            }
        }
        return ans;
    }

}
