class Solution {
    public int fib(int n) { // O(n) | O(1)
        if(n < 2)
            return n;
        
        int prev1 = 0;
        int prev2 = 1;
        
        for(int i = 1; i < n; i++){
            int temp = prev1;
            prev1 = prev2;
            prev2 += temp;
        }
        return prev2;
    }
}
