class Solution
{
    //Function to modify the matrix such that if a matrix cell matrix[i][j]
    //is 1 then all the cells in its ith row and jth column will become 1.
    void booleanMatrix(int matrix[][]) // O(N*M) | auxSpace(n+m)
    {
        
        HashSet<Integer> hr = new HashSet<>(); 
        HashSet<Integer> hc = new HashSet<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j]==1){
                    hr.add(i);
                    hc.add(j);
                }
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(hr.contains(i)||hc.contains(j))
                    matrix[i][j] = 1;
                }
            }
    }
}
