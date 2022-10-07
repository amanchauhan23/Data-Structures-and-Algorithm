class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] mat)
    {
        int dist[][] = new int[][]{
           {0,1}, {1, 0},
           {0, -1}, {-1, 0}
       };

       int l = mat.length;
       int w = mat[0].length;
       int result[][] = new int[l][w];
       Queue<int []> q = new LinkedList<>();

       for(int i = 0; i < l; i++){
           for(int j = 0; j < w; j++){
               if(mat[i][j] == 1){
                  q.add(new int[]{i, j});
                  mat[i][j] = 0;
               }else{
                   mat[i][j] = -1;
               }
           }
        } 

        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            while(size-- > 0){
                int pop[] = q.poll();
                int row = pop[0];
                int col = pop[1];

                for(int [] arr : dist){
                    int nrow = row + arr[0];
                    int ncol = col + arr[1];
                    if(nrow < 0 || ncol < 0 || nrow == l || ncol == w || mat[nrow][ncol] != -1) continue;
                    mat[nrow][ncol] = level;
                    q.offer(new int[]{nrow, ncol});
                }
            }
        }

        return mat;
    }
}
