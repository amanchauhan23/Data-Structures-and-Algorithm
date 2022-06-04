class NumMatrix {
private int T[][];
    public NumMatrix(int[][] matrix) {
        // #1
        // this.matrix = matrix;

        // #2 | O(mn) | O(mn) | DP
         if (matrix.length == 0)
            return;
        T = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++)
                T[i][j] = T[i - 1][j] + T[i][j - 1] - T[i - 1][j - 1] + matrix[i - 1][j - 1];
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // #1 Naive Timelimit Exceed | O(m*n)
        // int sum = 0;
        // for(int i = row1; i <= row2; i++){
        // for(int j = col1; j <= col2; j++){
        // sum+=matrix[i][j];
        // }
        // }
        // return sum;

        // #2 | O(1)
        row1++;
        col1++;
        row2++;
        col2++;
        return T[row2][col2] - T[row1 - 1][col2] - T[row2][col1 - 1] + T[row1 - 1][col1 - 1];
    }
}
