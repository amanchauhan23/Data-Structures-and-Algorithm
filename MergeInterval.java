class Solution {
    public int[][] merge(int[][] intervals) {           // O(nlogn)
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int j = 0;
        List<int[]> ls = new ArrayList<>();
        ls.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int lsInterval[] = ls.get(j);
            if(lsInterval[1] >= intervals[i][0]){
                lsInterval[1] = Math.max(lsInterval[1], intervals[i][1]);
            }else{
                ls.add(intervals[i]);
                j++;
            }
        }
        int[][] res = new int[ls.size()][2];
        for(int i = 0; i < ls.size(); i++){
            res[i][0] = ls.get(i)[0];
            res[i][1] = ls.get(i)[1];
        }
        return res;
    }
}
