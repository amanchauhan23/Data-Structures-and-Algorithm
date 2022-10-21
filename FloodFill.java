class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color != image[sr][sc])
            dfs(sr, sc, color, image[sr][sc], image);
        return image;
    }

    void dfs(int row, int col, int color, int start, int image[][]){
        if(row < 0 || col < 0 || row >= image.length || col >= image[0].length)
            return;
        else if(image[row][col] != start) return;

        image[row][col] = color;

        dfs(row + 1, col, color, start, image);
        dfs(row - 1, col, color, start, image);
        dfs(row, col + 1, color, start, image);
        dfs(row, col - 1, color, start, image);
    }
}
