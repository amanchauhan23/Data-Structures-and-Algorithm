// #1
class Solution {
    public boolean checkIfPangram(String s) {
        boolean alpha[] = new boolean[26];
        int count = 0;
        for(char c : s.toCharArray()){
            if(!alpha[c - 'a']){
                alpha[c - 'a'] = true;
                count++;
            }
        } 
        return count == 26;
    }
}

//#2
class Solution {
    public boolean checkIfPangram(String s) {
        for(char c = 'a'; c <= 'z'; c++)
            if(s.indexOf(c) == -1) return false;
        return true;
    }
}
