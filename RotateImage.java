class Solution {
    public void rotate(int[][] matrix) {  // O(n*n) || O(1)
        // Transpose 
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reversing the row values || 90 degrees clockwise 
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }

    }
}
