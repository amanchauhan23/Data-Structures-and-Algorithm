class Solution {
    public List<String> topKFrequent(String[] words, int k) { // O(nlog(k)) || O(n)
        HashMap<String, Integer> hm = new HashMap<>();
        List<String> ls = new ArrayList<>();
        for(String s : words)
            hm.put(s, hm.getOrDefault(s, 0)+1);
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()
        ); 
        
        for(Map.Entry<String, Integer> ent : hm.entrySet())
            pq.offer(ent);
        

        System.out.println(hm);
            
        while(k-- > 0)
            ls.add(pq.poll().getKey());
        return ls;
    }
}
