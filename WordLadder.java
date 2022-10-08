// #1 O(n2m) || O(n)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String s : wordList) set.add(s);
        if(!set.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();
            level++;
            while(size-- > 0){
                String pop = q.poll();
                char [] c = pop.toCharArray();
                for(int i = 0; i < c.length; i++){
                    char presentChar = c[i];
                    for(char j = 'a'; j <= 'z'; j++){
                        c[i] = j;
                        String newString = String.valueOf(c);
                        if(set.contains(newString)){
                            if(newString.equals(endWord)) return level + 1;
                            q.offer(newString);
                            set.remove(newString);
                        }
                    }
                    c[i] = presentChar;
                }
            }
        }
        return 0;
    }
}
