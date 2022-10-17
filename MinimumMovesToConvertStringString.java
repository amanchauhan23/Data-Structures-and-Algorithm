class Solution {
    public int minimumMoves(String s) {
        int res = 0;
        for(int i = 0; i < s.length();){
            if(s.charAt(i) == 'O') i++;
            else if(s.charAt(i) == 'X'){
                res++;
                i+=3;
            }
        }
        return res;
    }
}
