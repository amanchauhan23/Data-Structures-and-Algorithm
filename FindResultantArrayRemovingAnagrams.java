class Solution {
    public List<String> removeAnagrams(String[] words) {  // O(n*m) || O(1) 
        List<String> ls = new ArrayList<>();
        if(words.length == 0) return ls;
        char[] prevHash = new char[26];
        for(int j = 0; j < words[0].length(); j++) 
            prevHash[words[0].charAt(j) - 'a']++;
        ls.add(words[0]);

        for(int i = 1; i < words.length; i++){
            char[] cA = new char[26];
            for(int j = 0; j < words[i].length(); j++) 
                cA[words[i].charAt(j) - 'a']++;
            if(Arrays.equals(cA, prevHash)) continue;
            ls.add(words[i]);
            prevHash = cA;
        }
        return ls;
    }
}
