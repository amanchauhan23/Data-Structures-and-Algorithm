class Solution // O(mn) || O(mn)
{
    public int LongestRepeatingSubsequence(String str)
    {
        int memo[][] = new int[str.length() + 1][str.length() + 1];
    
        return rec(memo, str, str, 0, 0);
    }
    
    int rec(int memo[][], String s1, String s2, int i, int j){
        if(i == s1.length() || j == s1.length())
            return 0;
        if(memo[i][j] != 0)     
            return memo[i][j];
        if(i != j && s1.charAt(i) == s2.charAt(j))
            memo[i][j] = 1 + rec(memo, s1, s2, i+1, j+1);
        else 
            memo[i][j] = Math.max(rec(memo, s1, s2, i+1, j), rec(memo, s1, s2, i, j+1));
            
        return memo[i][j];
    }
    
}
