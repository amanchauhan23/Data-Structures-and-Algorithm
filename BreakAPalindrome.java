class Solution {
    public String breakPalindrome(String s) { // O(n) || O(1)
        int len = s.length();
        if(len == 1) return "";
        char [] arr = s.toCharArray();
        for(int i = 0; i < len; i++){
            int j = len - 1 - i;
            if(i == j) continue;            // for odd length palindrome
            if(arr[i] != 'a'){
                arr[i] = 'a';
                return String.valueOf(arr);
            }
        }
        arr[len - 1] = 'b';
        return String.valueOf(arr);
    }
}
