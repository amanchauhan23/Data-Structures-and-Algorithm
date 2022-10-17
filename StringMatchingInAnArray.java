class Solution {
    public List<String> stringMatching(String[] words) {   // O(n*n) || O(n)
        HashSet<String> hs = new HashSet<>();
        for(int i = 0; i < words.length; i++){
            String t = words[i];
            for(int j = 0; j < words.length; j++){
                if(t == words[j]) continue;
                if(words[j].contains(t)) hs.add(t);
            }
        }
        List<String> ls = new ArrayList<>(hs);
        return ls;
    }
}
