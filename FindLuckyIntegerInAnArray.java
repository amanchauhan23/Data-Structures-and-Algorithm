// #1
class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        int ans = -1;
        for(Map.Entry<Integer, Integer> map : hm.entrySet()){
            if(map.getValue() == map.getKey()){
                ans = Math.max(ans, map.getKey());
            }
        }
        return ans;
    }
}

// #2
class Solution {
    public int findLucky(int[] arr) {
        int freq[] = new int[501];
        for(int i : arr)
            freq[i]++;
            
        int ans = 0;

        for(int i = 500; i > 0; i--)
           if(freq[i] == i)
               return i;

        return -1;
    }
}
