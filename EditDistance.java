// #1 Recursive || O(2^N) 
class Solution { 
    public int minDistance(String word1, String word2) {
        return rec(word1, word2, word1.length(), word2.length());
    }
    
    int rec(String s, String t,  int m, int n){
        
        if(m == 0)
            return n;
        if(n == 0)
            return m;
    
             if(s.charAt(m - 1) == t.charAt(n - 1))
                  return rec(s, t, m - 1, n - 1);
             else{
                  int min = Math.min(rec(s, t, m - 1, n - 1), rec(s, t, m, n - 1));
                  return Math.min(rec(s, t, m - 1, n), min) + 1;
            }
        }
}

// #2 Recursion + Memoization || O(mn)
class Solution {
    int [][]memo;
    public int minDistance(String word1, String word2) { // O(mn) | O(mn)
        memo = new int[word1.length()][word2.length()];
        for(int []i : memo)
            Arrays.fill(i, -1);
        return rec(word1, word2, word1.length(), word2.length());
    }
    
    int rec(String s, String t,  int m, int n){
        
        if(m == 0)
            return n;
        if(n == 0)
            return m;
    
        if(memo[m - 1][n -1] == -1){
             if(s.charAt(m - 1) == t.charAt(n - 1))
                memo[m -1][n -1] =  rec(s, t, m - 1, n - 1);
            else{
            int min = Math.min(rec(s, t, m - 1, n - 1), rec(s, t, m, n - 1)); // trying for insert, delete, replace
            memo[m - 1][n -1] = Math.min(rec(s, t, m - 1, n), min) + 1;
            }
        }
       return memo[m - 1][n - 1];
    }
}

// #3 Tabulation || O(mn)
class Solution {
    public int minDistance(String word1, String word2) {
        
        int tab[][] = new int[word2.length() + 1][word1.length() + 1];
        for(int i = 0; i < tab.length; i++)
            tab[i][0] = i;
        for(int i = 0; i < tab[0].length; i++)
            tab[0][i] = i;
        
        for(int i = 1; i < tab.length; i++){
            for(int j = 1; j < tab[0].length; j++){
                if(word2.charAt(i - 1) == word1.charAt(j - 1))
                    tab[i][j] = tab[i - 1][j - 1];
                else
                    tab[i][j] = Math.min(tab[i - 1][j - 1], Math.min(tab[i - 1][j], tab[i][j - 1])) + 1;
            }
        }
        
        return tab[word2.length()][word1.length()];
    }
}
