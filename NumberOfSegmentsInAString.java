// #1
class Solution {
    public int countSegments(String s) {
        if(s.equals(""))
            return 0;
        
        int count = 0;
        String[] split = s.split(" ");
        for(String word : split){
            if(!word.trim().equals("")){
                count++;
            }
        }
        return count;
    }
}

// #2
class Solution {
    public int countSegments(String s) {
        s = s.trim();
        if(s.equals("")) return 0;
        return s.split(" +").length;
    }
}
