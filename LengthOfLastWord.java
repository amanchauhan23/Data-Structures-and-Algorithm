class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0;
        int count = 0;
        s = s.trim();
        int i = s.length() - 1;
        while(i >= 0){
            if(s.charAt(i--) != ' ') count++;
            else break;
        }
        return count;
    }
}
