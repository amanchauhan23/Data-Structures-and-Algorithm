 public int maxProfit(int[] prices) {
        // #1 Naive Sol | O(n2)
        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < prices.length - 1; i++) {
        //     for (int j = i + 1; j < prices.length; j++) {
        //         if (max < (prices[j] - prices[i])) {
        //             max = prices[j] - prices[i];
        //         }
        //     }
        // }
        // return (max < 0) ? 0 : max;
        
        // #2 O(N)
        int max = Integer.MIN_VALUE;
        int maxElement = Integer.MIN_VALUE;
        for (int i = prices.length-1; i >= 0; i--) {
            maxElement = Math.max(maxElement, prices[i]);
            max = Math.max(max, maxElement - prices[i]);
        }
        return max;
        
        // int max = Integer.MIN_VALUE;
        // int min = Integer.MAX_VALUE;
        // for (int i = 0; i < prices.length; i++) {
        //     min = Math.min(min, prices[i]);
        //     max = Math.max(max, prices[i] - min);
        // }
        // return max;
    }
