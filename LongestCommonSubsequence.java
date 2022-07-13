// #1 Plain Recursion || O(2^n)
public int longestCommonSubsequence(String text1, String text2) { 
        return LCS(0, 0, text1, text2);
    }
    
    int LCS(int i, int j, String s1, String s2){ 
        
        if(i == s1.length() || j == s2.length())
            return 0;
      
        if(s1.charAt(i) == s2.charAt(j))
            return 1 + LCS(i+1, j+1, s1, s2, memo);
        else
            return Math.max(LCS(i, j+1, s1, s2, memo), LCS(i+1, j, s1, s2, memo));
    }


// #2 Memoization || O(mn) | Top - down
public int longestCommonSubsequence(String text1, String text2) {
        
        int [][] memo = new int[text1.length()][text2.length()];
        
        for(int []a : memo)
            Arrays.fill(a, -1);
        
        return LCS(0, 0, text1, text2, memo);
    }
    
    int LCS(int i, int j, String s1, String s2, int[][]memo){ 
        
        if(i == s1.length() || j == s2.length())
            return 0;
        
        if(memo[i][j] == -1){
            if(s1.charAt(i) == s2.charAt(j))
                memo[i][j] = 1 + LCS(i+1, j+1, s1, s2, memo);
            else
                memo[i][j] = Math.max(LCS(i, j+1, s1, s2, memo), LCS(i+1, j, s1, s2, memo));
        }
        return memo[i][j];
    }

// #3 Tabulation || O(mn) | Bottom - Up
public int longestCommonSubsequence(String text1, String text2) {
     
        int m = text1.length(), n = text2.length();
        int tab[][] = new int[m+1][n+1];
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    tab[i][j] = tab[i - 1][j - 1] + 1;
                }else{
                    tab[i][j] = Math.max(tab[i - 1][j], tab[i][j - 1]);
                }
            }
        }
        return tab[m][n];
    }
