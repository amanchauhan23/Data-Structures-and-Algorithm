class Solution {
    public int minDeletions(String s) { // O(n + k2) | O(k) | n len of string, k is max possible number of distinct character
        int freq[] = new int[26];
        for(int i = 0; i <  s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        
        int ans = 0;
        
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < 26; i++){
            while(freq[i] > 0 && hs.contains(freq[i])){
                freq[i]--;
                ans++;
            }
            hs.add(freq[i]);
        }
        return ans;
    }
}
