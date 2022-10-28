class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        List<Integer> ls = new ArrayList<>();

        
        while(left <= right && top <= bottom){

            // left to right
            for(int i = left; i <= right; i++)
                ls.add(matrix[top][i]);
            top++;
            
            // top to bottom
            for(int i = top; i <= bottom; i++)
                ls.add(matrix[i][right]);
            right--;

            // check if conditions get violated mid-way
            if (left > right || top > bottom)
                break;

            // right to left
            for(int i = right; i >= left; i--)
                ls.add(matrix[bottom][i]);
            bottom--;

            // bottom to top
            for(int i = bottom; i >= top; i--)
                ls.add(matrix[i][left]);
            left++;

        }
        return ls;
    }
}
