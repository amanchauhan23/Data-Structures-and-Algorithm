class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) { // O(nlogn) | O(1) 
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long maxHorizontalInterval = Long.MIN_VALUE;
        long maxVerticalInterval = Long.MIN_VALUE;
        
        long prev = 0;
        for(int i : horizontalCuts){
            maxHorizontalInterval = Math.max(maxHorizontalInterval, i - prev);
            prev = i;
        }
        maxHorizontalInterval = Math.max(maxHorizontalInterval, h - horizontalCuts[horizontalCuts.length - 1]);
        
        prev = 0;
        for(int i : verticalCuts){
            maxVerticalInterval = Math.max(maxVerticalInterval, i - prev);
            prev = i;
        }
        maxVerticalInterval = Math.max(maxVerticalInterval, w - verticalCuts[verticalCuts.length - 1]);

        return (int)(maxVerticalInterval*maxHorizontalInterval % 1000000007);
        
    }
}
