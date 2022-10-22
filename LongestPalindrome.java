// #1
class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int freq = hm.getOrDefault(c, 0);
            hm.put(c, freq + 1);
            if((freq+1)%2 == 0) res += 2;
        }
        if(res == s.length()) return res;
        return res + 1;
    }
}

// #2
class Solution {
    public int longestPalindrome(String s) {
        int freq[] = new int[128];
        int res = 0;
        int len = s.length();
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            freq[c]++;
            if(freq[c]%2 == 0) res += 2;
        }
        return res == len ? res : res + 1;
    }
}
