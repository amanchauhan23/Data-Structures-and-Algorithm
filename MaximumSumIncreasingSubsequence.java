class Solution
{
	public int maxSumIS(int arr[], int n)  // O(n^2) | O(n) // see LIS for similarities
	{ 
	    int msis[] = new int[n];
	    for(int i = 0; i < n; i++){
	        msis[i] = arr[i];
	        for(int j = 0; j < i; j++){
	            if(arr[j] < arr[i])
	                msis[i] = Math.max(msis[i], arr[i] + msis[j]);
	        }
	    }
	    int ans = Integer.MIN_VALUE;
	    for(int i : msis)
	        ans = Math.max(i, ans);
	    return ans;
	}  
}
