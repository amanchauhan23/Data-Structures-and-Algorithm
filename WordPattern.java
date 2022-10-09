class Solution { // O(n*m) || O(n)
    public boolean wordPattern(String pattern, String s) {
        String arr[] = s.split(" ");
        HashMap<Character, String> hm = new HashMap<>();
        if(arr.length != pattern.length()) return false;
        
        for(int i = 0; i < arr.length; i++){
            if(hm.containsKey(pattern.charAt(i))){
                if(!hm.get(pattern.charAt(i)).equals(arr[i]))
                   return false;
            }
            else if(hm.containsValue(arr[i])){
                return false;
            } 
            hm.put(pattern.charAt(i), arr[i]);
        }
        return true;
    }
}
