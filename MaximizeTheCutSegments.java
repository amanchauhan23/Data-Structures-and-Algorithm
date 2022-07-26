// #1 
//Function to find the maximum number of cuts.
public int maximizeCuts(int n, int x, int y, int z) // O(3^n)
    {
        if(n==0)
            return 0;
        if(n < 0)
            return -1;
        int xVal = maximizeCuts(n - x, x, y, z);
        int yVal = maximizeCuts(n - y, x, y, z);
        int zVal = maximizeCuts(n - z, x, y, z);
        
        int res =  Math.max(xVal, Math.max(yVal, zVal));
        
        if(res == -1)
            return -1;
        return res + 1;
    }

// #2 using memoization
class Solution
{
    //Function to find the maximum number of cuts.
    int memo[];
    public int maximizeCuts(int n, int x, int y, int z)
    {
       memo = new int[n + 1];
       Arrays.fill(memo, -1);
       int ans = maximizeCut(n, x, y, z);
       if(ans < 0)
          return 0;
        return ans;
    }
    
    public int maximizeCut(int n, int x, int y, int z){
        
        if(n == 0)
            return 0;
        if(n < 0)
            return Integer.MIN_VALUE;
        
        if(memo[n] != -1)
            return memo[n];
        int xVal = maximizeCut(n - x, x, y, z);
        int yVal = maximizeCut(n - y, x, y, z);
        int zVal = maximizeCut(n - z, x, y, z);
        
        memo[n] =  Math.max(xVal, Math.max(yVal, zVal)) + 1;
        
        return memo[n];
        
    }
    
}


// #3 
