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
