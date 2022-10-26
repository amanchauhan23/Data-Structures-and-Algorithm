// #1 min - heap  || O(nlogk) || O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int n : nums)
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );
        for(Map.Entry<Integer, Integer> map : hm.entrySet())
            pq.offer(map);
        int [] res = new int[k];
        int i = 0;
        while(k-- > 0) res[i++] = pq.poll().getKey();
        return res;
    }
}

// #2 || O(n) || O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> hm = new HashMap<>(); // Element -> Frequency
        
        for(int n : nums)
            hm.put(n, hm.getOrDefault(n, 0) + 1);      // creating frequency from elements
        
        List<List<Integer>> bucket = new ArrayList<>();         // bucket will store, frequency(i) at ith index, and corresponding list will have elements
        for(int i = 0; i <= nums.length; i++) bucket.add(new ArrayList<>());  // with i frequency, i.e. if 2 occurs 10 times, then at 10th index we will have list
                                                                            // containing element 2
        for(Map.Entry<Integer, Integer> map : hm.entrySet())
            bucket.get(map.getValue()).add(map.getKey());

        int [] res = new int[k];
        int idx = 0;

        for(int i = bucket.size() - 1; i >= 0; i--){             // starting from end taking 'k' highest occurences of element
            for(int j = 0; j < bucket.get(i).size(); j++)
                res[idx++] = bucket.get(i).get(j);
            if(idx == k) break;
        }

        return res;
    }
}

