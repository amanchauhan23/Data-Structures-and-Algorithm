class Solution { // Tabulation || O(mn) || O(mn)
    public String shortestCommonSupersequence(String str1, String str2) {
        
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
	    StringBuffer sb = new StringBuffer();
        
	    for(int i = 1; i <= str1.length(); i++){
	        for(int j = 1; j <=str2.length(); j++){
	            if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
	            else
	                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
	        }
	    }
        
        int i = str1.length(), j = str2.length();
        
        while(i > 0 && j > 0){
            if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                sb.insert(0, str1.charAt(i - 1));
                i--;
                j--;
            }else{
                if(dp[i-1][j] >= dp[i][j-1]){
                    sb.insert(0, str1.charAt(i-1));
                    i--;
                }
                else{
                    sb.insert(0, str2.charAt(j-1));
                    j--;
                }
                
            }
        }
        if(i > 0)
            while(i!=0)
                sb.insert(0, str1.charAt(i-- - 1));
        if(j > 0)
            while(j!=0)
                sb.insert(0, str2.charAt(j-- - 1));
        
        return sb.toString();
        
    }
}
