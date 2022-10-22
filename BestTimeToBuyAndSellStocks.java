class Solution {
    public int maxProfit(int[] prices) {  // O(n) || O(1)
        if(prices.length == 0) return 0;
        int maxPro = 0;
        int min = prices[0];
        for(int i = 0; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            maxPro = Math.max(maxPro, prices[i] - min);
        }
        
        return maxPro < 0 ? 0 : maxPro;
    }
}
