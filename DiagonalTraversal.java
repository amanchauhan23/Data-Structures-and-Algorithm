class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if(mat.length == 0 && mat[0].length == 0) return new int[0];  // O(n) || O(1)
        int m = mat.length;
        int n = mat[0].length;
        int arr[] = new int[m*n];
        int i = 0;
        int row = 0;
        int col = 0;
        boolean up = true;

        while(row < m && col < n){
            if(up){
                while(row > 0 && col < n - 1){
                    arr[i++] = mat[row--][col++];
                }
                arr[i++] = mat[row][col];
                if(col == n - 1)row++;
                else col++;
            }
            else{
                while(row < m - 1 && col > 0){
                    arr[i++] = mat[row++][col--];
                }
                arr[i++] = mat[row][col];
                if(row == m - 1) col++;
                else row++;
            }
            up = !up;
        }
        return arr;
    }
}
