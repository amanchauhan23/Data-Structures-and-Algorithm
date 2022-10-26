class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1])
        );
        for(int [] arr : points)
            pq.add(arr);
        int [][] res = new int[k][2];
        int i = 0;
        while(k-- > 0){
            int[] temp = pq.poll();
            res[i][0] = temp[0];
            res[i][1] = temp[1];
            i++;
        }
        return res;
    }
}
