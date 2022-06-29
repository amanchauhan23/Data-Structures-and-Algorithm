class Solution {
    public List<List<Integer>> findWinners(int[][] matches) { // O(n) | O(n)
        
        HashMap<Integer, Integer> hmL = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 0; i < matches.length; i++){
                hmL.put(matches[i][1], hmL.getOrDefault(matches[i][1], 0) + 1);
                hs.add(matches[i][0]);
                hs.add(matches[i][1]);
        }
        List<Integer> lostOneTime = new ArrayList<>();
        for(Map.Entry<Integer, Integer> m : hmL.entrySet()){
            if(m.getValue() == 1)
                lostOneTime.add(m.getKey());
        }
        
        for(Map.Entry<Integer, Integer> m : hmL.entrySet()){
            hs.remove(m.getKey());
        }
        List<Integer> won = new ArrayList<>(hs);
        
        Collections.sort(won);
        Collections.sort(lostOneTime);
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(won);
        ans.add(lostOneTime);
        return ans;
    }
}
