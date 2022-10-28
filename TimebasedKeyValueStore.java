class TimeMap { // O(timestamp) || O(1)

    private HashMap<String, HashMap<Integer, String>> HM;

    public TimeMap() {
        HM = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) { // O(1)
        if(HM.containsKey(key)){
            HashMap<Integer, String> innerHM = HM.get(key);
            innerHM.put(timestamp, value);
        }else{
            HashMap<Integer, String> innerHM = new HashMap<>();
            innerHM.put(timestamp, value);
            HM.put(key, innerHM);
        }
    }
    
    public String get(String key, int timestamp) { // O(timestamp)
        
        HashMap<Integer, String> innerHM = HM.get(key);
        if(innerHM == null) return "";
        
        while(timestamp >= 1 && innerHM.get(timestamp) == null){
            timestamp--;
        }
        if(timestamp == 0) return "";
        return innerHM.get(timestamp);

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

// #2 Optimized
class TimeMap {
    static HashMap<String, ArrayList<Pair<Integer, String>>> hm;
    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!hm.containsKey(key))
            hm.put(key, new ArrayList<Pair<Integer, String>>());
        hm.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(hm.get(key) == null) return "";
        int left = 0; 
        int right = hm.get(key).size() - 1;
        ArrayList<Pair<Integer, String>> temp = hm.get(key);
        while(left <= right){
            int mid = left + (right - left)/2;
            if(temp.get(mid).getKey() == timestamp) return temp.get(mid).getValue();
            if(temp.get(mid).getKey() < timestamp){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        if(right < 0) return "";
        return temp.get(right).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
