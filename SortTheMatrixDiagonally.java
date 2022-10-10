// #1 O(m*nlog(min(m, n) || O(mn)
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int nr = mat.length;
        int nc = mat[0].length;
        int size = nr + nc - 1;
        HashMap<Integer, PriorityQueue<Integer>> hm = new HashMap<>();
        for(int i = 0; i < nr; i++){
            for(int j = 0; j < nc; j++){
                PriorityQueue<Integer> pq = hm.getOrDefault(i - j, new PriorityQueue<Integer>());
                pq.add(mat[i][j]);
                hm.put(i - j, pq);
            }
        }
        for(int i = 0; i < nr; i++){
            for(int j = 0; j < nc; j++){
                mat[i][j] = hm.get(i - j).poll();
            }
        }
        return mat;
    }
}

// #2 
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int nr = mat.length;
        int nc = mat[0].length;
        
        for(int i = 0; i < nr; i++)
            sort(mat, i, 0);
        for(int j = 1; j < nc; j++)
            sort(mat, 0, j);
        
        return mat;
    }

    private void sort(int [][]mat, int i, int j){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int row = i;
        int col = j;
        while(row < mat.length && col < mat[0].length){
            pq.add(mat[row++][col++]);
        }
        while(i < mat.length && j < mat[0].length){
            mat[i++][j++] = pq.poll();
        }
    }
}
