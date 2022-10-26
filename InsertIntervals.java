class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ls = new ArrayList<>();
        int i = 0;
        // Pairs which are smaller and need not to be merged
        while(i < intervals.length && intervals[i][1] < newInterval[0])
            ls.add(intervals[i++]);

        // Merging Overlapping intervals
        ls.add(newInterval);
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Adding the remaining intervals
        while(i < intervals.length)
            ls.add(intervals[i++]);
        
        return ls.toArray(new int[ls.size()][2]);
        
    }
}
