// O(n^2) || O(n)
class Solution
{
	public int minDeletions(int arr[], int n) 
	{ 
	   int []dp = new int[n];
	   
	   for(int i = 0; i < n; i++){
	       dp[i] = 1; 
	       for(int j = 0; j < i; j++){
	           if(arr[j] < arr[i]){
	               dp[i] = Math.max(dp[i], dp[j] + 1);
	           }
	       }
	   }
	   
	   int ans = 0;
	   for(int i : dp)
	       ans = Math.max(ans, i);
	   
	   return n - ans;
	} 
}
