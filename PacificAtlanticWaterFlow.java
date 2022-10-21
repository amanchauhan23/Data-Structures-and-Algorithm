class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {   // O(mn) || O(mn)
        int [][] pacific = new int[heights.length][heights[0].length];
        int [][] atlantic = new int[heights.length][heights[0].length];

        for(int i = 0; i < heights.length; i++){
            dfs(i, 0, Integer.MIN_VALUE, heights, pacific);
            dfs(i, heights[0].length - 1, Integer.MIN_VALUE, heights, atlantic);
        }

        for(int i = 0; i < heights[0].length; i++){
            dfs(0, i, Integer.MIN_VALUE, heights, pacific);
            dfs(heights.length- 1, i, Integer.MIN_VALUE, heights, atlantic);
        }

        List<List<Integer>> ls = new ArrayList<>();
        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                if(pacific[i][j] == 1 && atlantic[i][j] == 1)
                    ls.add(new ArrayList<Integer>(Arrays.asList(i, j)));
            }
        }
        return ls;
    }

    private void dfs(int row, int col, int preVAl,int heights[][], int[][] ocean){
        if(row < 0 || col < 0 || row >= ocean.length || col >= ocean[0].length)
            return;
        else if(heights[row][col] < preVAl) 
            return;
        else if(ocean[row][col] == 1)
            return;
        
        ocean[row][col] = 1;

        dfs(row + 1, col, heights[row][col], heights, ocean);
        dfs(row, col + 1, heights[row][col], heights, ocean);
        dfs(row - 1, col, heights[row][col], heights, ocean);
        dfs(row, col - 1, heights[row][col], heights, ocean);
    }

}
