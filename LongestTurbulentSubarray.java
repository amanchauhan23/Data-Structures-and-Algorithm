// #1 || O(n) | O(1)
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int max = 1;
        int curr = 0;
        for(int i = 0; i < arr.length; i++){
            if(i >= 2 && ((arr[i-2] > arr[i-1] && arr[i-1] < arr[i]) || (arr[i-2] < arr[i-1] && arr[i-1] > arr[i])))
                curr += 1;
            else if(i >= 1 && arr[i-1] != arr[i])
                curr = 2;
            else
                curr = 1;
            max = Math.max(curr, max);
        }
        return max;
    }
}

// #2 || DP || O(n) || O(n)
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length == 1) return 1;
        int dp[][] = new int[arr.length][2];
        for(int [] i : dp) Arrays.fill(i, 1);  
        int max = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i-1] < arr[i])
                dp[i][0] = dp[i-1][1] + 1;   
            else if(arr[i-1] > arr[i])
                dp[i][1] = dp[i-1][0] + 1;
            max = Math.max(max, Math.max(dp[i][1], dp[i][0]));
        }
        return max;
    }
}
