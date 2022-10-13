class Solution {
    public int heightChecker(int[] heights) {  // O(nlogn) || O(n) 
        
        int [] correct = Arrays.copyOf(heights, heights.length);
        Arrays.sort(correct);
        int ans = 0;

        for(int i = 0; i < heights.length; i++)
            if(correct[i] != heights[i])
                ans++;
            
        return ans;
    }
}
