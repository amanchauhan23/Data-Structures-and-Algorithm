class Solution {
    public boolean isPowerOfFour(int n) {
        
        for(int i = 0; i < 10000; i++){
            if(n == Math.pow(4, i))
                return true;
            if(n < Math.pow(4, i))
                return false;
        }
        return false;
        
    }
}
