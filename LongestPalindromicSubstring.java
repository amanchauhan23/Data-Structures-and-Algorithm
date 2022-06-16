class Solution {
    public String longestPalindrome(String s) {
        
// #1
//         int len = 0;
//         String ans = "";
//         // odd case
//         for(int i = 0; i < s.length(); i++){
//             int L = i, R = i;
//             while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
//                 if((R - L + 1) > len){
//                     len = R - L + 1;
//                     ans = s.substring(L, R+1);
//                 }
//                 L--;
//                 R++;
//             }
//         }
        
//         // even case
//         for(int i = 0; i < s.length(); i++){
//             int L = i, R = i+1;
//             while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
//                 if((R - L + 1) > len){
//                     len = R - L + 1;
//                     ans = s.substring(L, R+1);
//                 }
//                 L--;
//                 R++;
//             }
//         }
        
//         return ans;
      
        // #2
        int len = 0;
        int ansL = 0;
        int ansR = 0;
        // odd case
        for(int i = 0; i < s.length(); i++){
            int L = i, R = i;
            while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
                if((R - L + 1) > len){
                    len = R - L + 1;
                    ansL = L;
                    ansR = R;
                }
                L--;
                R++;
            }
        }
        
        // even case
        for(int i = 0; i < s.length(); i++){
            int L = i, R = i+1;
            while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
                if((R - L + 1) > len){
                    len = R - L + 1;
                    ansL = L;
                    ansR = R;
                }
                L--;
                R++;
            }
        }
        
        return s.substring(ansL, ansR+1);
        
    }
}
