class Solution {
    public void setZeroes(int[][] matrix) { // O(n*m) | auxSpace O(n+m)

        HashSet<Integer> hr = new HashSet<>(); 
        HashSet<Integer> hc = new HashSet<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j]==0){
                    hr.add(i);
                    hc.add(j);
                }
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(hr.contains(i)||hc.contains(j))
                    matrix[i][j] = 0;
                }
            }
    }
}
