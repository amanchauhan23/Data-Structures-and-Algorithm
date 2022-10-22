// #1
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) { 
        
        int [] freq = new int[26];
        for(int i = 0; i < magazine.length(); i++)
            freq[magazine.charAt(i) - 'a']++;
        for(int i = 0; i < ransomNote.length(); i++)
            if(freq[ransomNote.charAt(i) - 'a']-- == 0) return false;
        
        return true;

    }
}

// #2
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        if(ransomNote.length() > magazine.length()) return false;
        int [] freq = new int[26];
        int letters = ransomNote.length();

        for(int i = 0; i < ransomNote.length(); i++)
            freq[ransomNote.charAt(i) - 'a']++;
        
        for(int i = 0; i < magazine.length(); i++){
            if(freq[magazine.charAt(i) - 'a'] != 0){
                freq[magazine.charAt(i) - 'a']--;
                if(--letters == 0) return true; 
            }
        }
    
        return false;

    }
}
