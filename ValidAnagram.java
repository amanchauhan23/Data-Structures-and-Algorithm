class Solution {
    public boolean isAnagram(String s, String t) { // O(m+n) | O(1)
        char[] ss = new char[26];
        char[] tt = new char[26];
        
        for(int i = 0; i < s.length(); i++)
            ss[s.charAt(i) - 'a']++;
        
        for(int i = 0; i < t.length(); i++)
            tt[t.charAt(i) - 'a']++;
        
        for(int i = 0; i < 26; i++)
            if(tt[i] != ss[i])
                return false;
        
        return true;
    }
}
