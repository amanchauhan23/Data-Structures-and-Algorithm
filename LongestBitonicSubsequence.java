class Solution
{
    public int LongestBitonicSequence(int[] nums) // O(n2) || (n)
    {
        int n = nums.length;
        int lis[] = new int[n];
        int lds[] = new int[n];
        
        for(int i = 0; i < n; i++){
            lis[i] = 1;
            for(int j = 0; j < i; j++)
                if(nums[j] < nums[i])
                    lis[i] = Math.max(lis[i], lis[j] + 1);
        }
        
        for(int i = n - 1; i >= 0; i--){
            lds[i] = 1;
            for(int j = n - 1; i < j; j--)
                if(nums[j] < nums[i])
                    lds[i] = Math.max(lds[i], lds[j] + 1);
        }
        
        int ans = 0;
        for(int i = 0; i < n; i++)
            ans = Math.max(lis[i] + lds[i] - 1, ans);
        
        return ans;
    }
}
